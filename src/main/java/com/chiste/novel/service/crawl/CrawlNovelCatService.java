package com.chiste.novel.service.crawl;

import com.chiste.novel.domain.crawl.CrawlNovelCat;

import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/4/26 10:30
 * @Description:
 **/
public interface CrawlNovelCatService {

    int batchInsertCat(List<CrawlNovelCat> list);
}
