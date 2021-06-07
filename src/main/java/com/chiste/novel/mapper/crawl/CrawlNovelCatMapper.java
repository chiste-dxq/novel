package com.chiste.novel.mapper.crawl;

import com.chiste.novel.domain.crawl.CrawlNovelCat;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CrawlNovelCatMapper extends Mapper<CrawlNovelCat> {
    int batchInsertCat(@Param("catList") List<CrawlNovelCat> list);

    List<CrawlNovelCat> queryCrawlNovelCatBySourceId(Integer sourceId);
}