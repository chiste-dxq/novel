package com.chiste.novel.common.util.crawl;

import com.chiste.novel.common.util.DateUtils;
import com.chiste.novel.common.util.RegexUtils;
import com.chiste.novel.common.util.RestTemplateUtil;
import com.chiste.novel.domain.crawl.CrawlNovelCat;
import com.chiste.novel.domain.crawl.CrawlSource;
import com.chiste.novel.domain.novel.RuleBean;
import com.chiste.novel.domain.novel.vo.NovelAddVo;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/4/26 10:31
 * @Description:
 **/
@Slf4j
public class CrawlUtils {

    private static RestTemplate restTemplate = RestTemplateUtil.getInstance("utf-8");


    public static List<CrawlNovelCat> getCats(CrawlSource crawlSource){
        List<CrawlNovelCat> lists = new ArrayList<>();
        String source_url = crawlSource.getSourceUrl();
        try {
            Document document = Jsoup.connect(source_url).get();
            Element element = document.getElementById(crawlSource.getSourceCatId());
            Elements catLinks = element.getElementsByTag("a");
            for (Element link : catLinks) {
                String href = link.attr("href");
                String title = link.attr("title");
                CrawlNovelCat cat = new CrawlNovelCat();
                cat.setCatName(title);
                cat.setCatHref(href);
                cat.setSourceId(12);
                lists.add(cat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lists;
    }

    public static List<NovelAddVo> parseBookList(RuleBean ruleBean, Integer sourceId,List<CrawlNovelCat> cats){
        List<NovelAddVo> list = new ArrayList<>();

        for(CrawlNovelCat cat : cats){
            int page = 1;
            while(true){
                //???????????????URL
                String bookListUrl = ruleBean.getBookListUrl()
                        .replace("{catUrl}",cat.getCatHref())
                        .replace("{pageUrl}","index_"+page+".html");
                try {
                    Document document = Jsoup.connect(bookListUrl).get();
                    if(page == 2){
                        break;
                    }
                    Element div = document.getElementById("catalog");
                    Elements listbg = div.select("div[class='listbg']");
                    for(Element element : listbg){
                        NovelAddVo novel = new NovelAddVo();
                        String bookName = element.select("a[class='img']").attr("title");
                        String bookUrl = element.select("a[class='img']").attr("href");
                        Document bookDocument = Jsoup.connect(ruleBean.getBookDetailUrl().replace("{bookId}",bookUrl)).get();
                        String introduction = RegexUtils.contentRegex(bookDocument.getElementById("mainSoftIntro").text());
                        Elements trol = bookDocument.getElementsByClass("downInfoRowL");
                        Elements lis = trol.select("li");
                        String type = lis.get(1).text().substring(5);

                        novel.setAuditor(lis.get(0).selectFirst("a").text());
                        novel.setTypeString(type);
                        novel.setIntroduction(introduction.replaceAll("//s+",""));
                        novel.setTitle(bookName);
                        novel.setCreateTime(DateUtils.getNow());
                        novel.setUpdateTime(DateUtils.getNow());
                        novel.setCreateUser("0");
                        novel.setSource(sourceId);
                        novel.setUpdateUser("0");
                        String readUrl = bookDocument.selectFirst("li[class='yuedu']").selectFirst("a").attr("href").replace("1.","{index}.");
                        readUrl = ruleBean.getBookDetailUrl().replace("{bookId}",readUrl);
                        int i=1;
                        String filepath = "D://novel//"+cat.getId()+"//"+bookName+".txt";
                        File file = new File(filepath);
                        //?????????????????????
                        if(file.exists()){
                            log.info("{} ????????????,??????????????????",bookName);
                            break;
                        }
                        Document content = Jsoup.connect(readUrl.replace("{index}",i+"")).get();
                        while(content.getElementById("view_content_txt")!=null){
                            fileAdd(filepath,RegexUtils.contentRegex(content.getElementById("view_content_txt").text()));
                            i++;
                            content = Jsoup.connect(readUrl.replace("{index}",i+"")).get();
                        }
                        novel.setDownloadUrl(filepath);
                        list.add(novel);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                page++;
            }
        }


        return list;
    }

    public static String getByHttpClientWithChrome(String url){
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.add("user-agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.67 Safari/537.36");
            HttpEntity<String> requestEntity = new HttpEntity<>(null, headers);
            ResponseEntity<String> forEntity = restTemplate.exchange(url.toString(), HttpMethod.GET, requestEntity, String.class);

            if (forEntity.getStatusCode() == HttpStatus.OK) {
                return forEntity.getBody();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void fileAdd(String fileName, String content) {
        try{
            File file = new File(fileName);
            FileOutputStream fos = null;
            if(!file.exists()){
                file.createNewFile();//??????????????????????????????????????????
                fos = new FileOutputStream(file);//??????????????????
            }else{
                //????????????????????????????????????????????????????????????
                fos = new FileOutputStream(file,true);//????????????????????????????????????true,?????????????????????????????????
            }

            OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");//?????????UTF-8??????????????????

            osw.write(content+",");
            //?????????????????????
            osw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
