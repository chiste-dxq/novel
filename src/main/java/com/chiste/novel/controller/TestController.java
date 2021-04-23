package com.chiste.novel.controller;

import com.chiste.novel.domain.novel.Novel;
import com.chiste.novel.service.novel.NovelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/*
 * @Author: daixq
 * @Date: 2021/4/21 16:46
 * @Description:
 **/
@RestController
@RequestMapping("/test")
@Api(tags = "测试接口" ,value = "测试接口")
public class TestController {

    @Resource
    private NovelService novelService;

    @GetMapping("/test")
    @ApiOperation("获取角色数据")
    public void querySysRole(){
        Long startTime, endTime;
        System.out.println("小爬虫开始了。。。。。。。。。。。");
        startTime = new Date().getTime();
        Document document;

        try {
            document = Jsoup.connect("http://book.qidian.com/info/1006141474#Catalog").get();
            Novel novel = new Novel();
            String fictionName = document.select("h1>em").text();
            novel.setTitle(fictionName);

            Elements results = document.select("a[data-cid]");
            for (Element e : results) {
                String fictionChapter = e.text();
                //只获取url不获取文字
                String fictionUrl = e.attr("abs:href");
                novel.setIntroduction(fictionUrl);
                novel.setSource(1);
                novelService.insert(novel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        endTime = new Date().getTime();
        System.out.println("小爬虫结束了，用时" + (endTime - startTime) + "ms");
    }

}
