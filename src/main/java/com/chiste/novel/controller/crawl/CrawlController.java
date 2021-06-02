package com.chiste.novel.controller.crawl;

import com.alibaba.fastjson.JSON;
import com.chiste.novel.common.base.ResultMap;
import com.chiste.novel.common.util.ResultUtils;
import com.chiste.novel.common.util.crawl.CrawlUtils;
import com.chiste.novel.domain.crawl.CrawlSource;
import com.chiste.novel.domain.crawl.vo.CrawlBeginReqVo;
import com.chiste.novel.domain.crawl.vo.CrawlSourceReqVo;
import com.chiste.novel.domain.novel.Novel;
import com.chiste.novel.domain.novel.RuleBean;
import com.chiste.novel.domain.novel.vo.NovelAddVo;
import com.chiste.novel.service.crawl.CrawlNovelCatService;
import com.chiste.novel.service.crawl.CrawlSourceService;
import com.chiste.novel.service.novel.NovelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/4/26 10:34
 * @Description:
 **/
@RestController
@RequestMapping("/api/crawl")
public class CrawlController {

    @Resource
    private CrawlNovelCatService crawlNovelCatService;
    @Resource
    private CrawlSourceService crawlSourceService;
    @Resource
    private NovelService novelService;

    @PostMapping("/batchInsert")
    @ApiOperation("批量添加爬虫源的章节分类url")
    public ResultMap batchInsert(@RequestBody CrawlSourceReqVo vo){
        crawlNovelCatService.batchInsertCat(CrawlUtils.getCats(crawlSourceService.selectCrawlSourceById(vo.getId())));
        return ResultUtils.success();
    }

    @PostMapping("/beginCrawl")
    @ApiOperation("开启爬虫")
    public ResultMap beginCrawl(@RequestBody CrawlBeginReqVo reqVo){
        CrawlSource crawlSource = crawlSourceService.selectCrawlSourceById(reqVo.getSourceId());
        RuleBean ruleBean = JSON.parseObject(crawlSource.getCrawlRule(),RuleBean.class);
        List<NovelAddVo> novels = CrawlUtils.parseBookList(reqVo.getCatId(),ruleBean,reqVo.getSourceId());
        novels.stream().forEach(novel -> {
            novelService.insertNovel(novel);
        });
        return ResultUtils.success();
    }
}
