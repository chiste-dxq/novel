package com.chiste.novel.controller.crawl;

import com.alibaba.fastjson.JSON;
import com.chiste.novel.common.annotion.Log;
import com.chiste.novel.common.base.ResultMap;
import com.chiste.novel.common.enums.BusinessType;
import com.chiste.novel.common.util.FileUtils;
import com.chiste.novel.common.util.ResultUtils;
import com.chiste.novel.common.util.crawl.CrawlUtils;
import com.chiste.novel.crawl.CacheManagerImpl;
import com.chiste.novel.crawl.EntityCache;
import com.chiste.novel.domain.crawl.CrawlNovelCat;
import com.chiste.novel.domain.crawl.CrawlSource;
import com.chiste.novel.domain.crawl.vo.CrawlBeginReqVo;
import com.chiste.novel.domain.crawl.vo.CrawlSourceReqVo;
import com.chiste.novel.domain.novel.RuleBean;
import com.chiste.novel.domain.novel.vo.NovelAddVo;
import com.chiste.novel.domain.novel.vo.NovelContentAddVo;
import com.chiste.novel.service.crawl.CrawlNovelCatService;
import com.chiste.novel.service.crawl.CrawlSourceService;
import com.chiste.novel.service.novel.NovelContentService;
import com.chiste.novel.service.novel.NovelService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * @Author: daixq
 * @Date: 2021/4/26 10:34
 * @Description:
 **/
@Slf4j
@RestController
@RequestMapping("/api/crawl")
public class CrawlController {

    @Resource
    private CrawlNovelCatService crawlNovelCatService;
    @Resource
    private CrawlSourceService crawlSourceService;
    @Resource
    private NovelService novelService;
    @Resource
    private NovelContentService novelContentService;

    private CacheManagerImpl cacheManager = new CacheManagerImpl();
    AtomicInteger pollingTime = new AtomicInteger(0);

    @PostMapping("/batchInsert")
    @ApiOperation("批量添加爬虫源的章节分类url")
    @Log(title="批量添加爬虫源的章节分类url", businessType = BusinessType.INSERT)
    public ResultMap batchInsert(@RequestBody CrawlSourceReqVo vo){
        crawlNovelCatService.batchInsertCat(CrawlUtils.getCats(crawlSourceService.selectCrawlSourceById(vo.getId())));
        return ResultUtils.success();
    }

    @PostMapping("/beginCrawl")
    @ApiOperation("开启爬虫")
    @Log(title="开启爬虫", businessType = BusinessType.OTHER)
    public void beginCrawl(@RequestBody CrawlBeginReqVo reqVo){
        CrawlSource crawlSource = crawlSourceService.selectCrawlSourceById(reqVo.getSourceId());
        RuleBean ruleBean = JSON.parseObject(crawlSource.getCrawlRule(),RuleBean.class);
        List<CrawlNovelCat> cats = crawlNovelCatService.queryCrawlNovelCatBySourceId(reqVo.getSourceId());
        List<NovelAddVo> novels = CrawlUtils.parseBookList(ruleBean, reqVo.getSourceId(), cats);
        new Thread(){
            @Override
            public void run() {
                novels.stream().forEach(novel -> {
                    novelService.insertNovel(novel);
                    cacheManager.putCache(String.valueOf(novel.getId()),novel,0);
                });
            }
        }.start();
        new Thread(){
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    // 判断缓存内是否有数据，无数据则线程休眠 2s
                    if(cacheManager.getAllKeys().isEmpty()){
                        try {
                            if(pollingTime.getAndIncrement() > 20){
                                // 阻塞次数超过10次，默认数据传输完成
                                Thread.currentThread().interrupt();
                                break;
                            }
                            // 等待生成视频数据缓存
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        pollingTime.set(0);
                        for(String key : cacheManager.getAllKeys()) {
                            EntityCache cache = cacheManager.getCacheByKey(key);
                            NovelAddVo novelAddVo = cache.getDatas();

                            /** 拆分章节操作开始 **/
                            List<NovelContentAddVo> list = FileUtils.readTxtFile(novelAddVo.getDownloadUrl(),novelAddVo.getId());
                            /** 拆分章节操作结束 **/

                            // 整合数据提交至数据库
                            novelContentService.batchInsertNovelContent(list);
                            cacheManager.clearByKey(key);
                            log.info("{} 存储至数据库成功！",novelAddVo.getTitle());
                        }
                    }
                }
                // 中断后线程数据还原
                pollingTime.set(0);
            }
        }.start();
    }

}
