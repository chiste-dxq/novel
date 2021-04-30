package com.chiste.novel.service.crawl.impl;

import com.chiste.novel.domain.crawl.CrawlSource;
import com.chiste.novel.mapper.crawl.CrawlSourceMapper;
import com.chiste.novel.service.crawl.CrawlSourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
 * @Author: daixq
 * @Date: 2021/4/26 10:36
 * @Description:
 **/
@Service
public class CrawlSourceServiceImpl implements CrawlSourceService {

    @Resource
    private CrawlSourceMapper crawlSourceMapper;

    @Override
    public CrawlSource selectCrawlSourceById(Integer sourceId) {
        return crawlSourceMapper.selectByPrimaryKey(sourceId);
    }

    @Override
    public int insertCrawlSource(CrawlSource source) {
        return crawlSourceMapper.insert(source);
    }
}
