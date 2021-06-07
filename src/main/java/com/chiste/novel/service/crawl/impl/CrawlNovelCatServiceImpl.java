package com.chiste.novel.service.crawl.impl;

import com.chiste.novel.domain.crawl.CrawlNovelCat;
import com.chiste.novel.mapper.crawl.CrawlNovelCatMapper;
import com.chiste.novel.service.crawl.CrawlNovelCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/4/26 10:30
 * @Description:
 **/
@Service
public class CrawlNovelCatServiceImpl implements CrawlNovelCatService {

    @Resource
    private CrawlNovelCatMapper crawlNovelCatMapper;

    @Override
    public int batchInsertCat(List<CrawlNovelCat> list) {
        return crawlNovelCatMapper.batchInsertCat(list);
    }

    @Override
    public List<CrawlNovelCat> queryCrawlNovelCatBySourceId(Integer sourceId) {
        return crawlNovelCatMapper.queryCrawlNovelCatBySourceId(sourceId);
    }
}
