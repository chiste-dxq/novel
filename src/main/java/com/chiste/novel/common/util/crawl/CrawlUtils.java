package com.chiste.novel.common.util.crawl;

import com.chiste.novel.common.util.RestTemplateUtil;
import com.chiste.novel.domain.crawl.CrawlNovelCat;
import com.chiste.novel.domain.crawl.CrawlSource;
import com.chiste.novel.domain.novel.RuleBean;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @Author: daixq
 * @Date: 2021/4/26 10:31
 * @Description:
 **/
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

    public static void parseBookList(Integer catId, RuleBean ruleBean,Integer sourceId){

        int page = 1;
        int totalPage = page;
        //按拼接分类URL
        String bookListUrl = ruleBean.getBookListUrl()
                .replace("{catUrl}",ruleBean.getCatUrlRule().get("catId"+catId))
                .replace("{pageUrl}","index_"+page+".html");
        try {
            Document document = Jsoup.connect(bookListUrl).get();
            Element div = document.getElementById("catalog");
            Elements elements = div.select("a[class='img']");
            String bookName = elements.attr("href");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
