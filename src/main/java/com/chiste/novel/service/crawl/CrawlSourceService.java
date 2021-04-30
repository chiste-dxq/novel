package com.chiste.novel.service.crawl;

import com.chiste.novel.domain.crawl.CrawlSource;

/*
 * @Author: daixq
 * @Date: 2021/4/26 10:35
 * @Description:
 **/
public interface CrawlSourceService {

    CrawlSource selectCrawlSourceById(Integer sourceId);

    int insertCrawlSource(CrawlSource source);
}
