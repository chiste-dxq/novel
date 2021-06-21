package com.chiste.novel.mapper.novel;

import com.chiste.novel.domain.novel.Novel;
import com.chiste.novel.domain.novel.vo.*;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NovelMapper extends Mapper<Novel> {
    int insertNovel(NovelAddVo addVo);

    List<NovelListResVo> queryNovel(NovelListReqVo reqVo);

    NovelChapterResVo getNovelOne(@Param("id") Integer id);

    NovelDetailResVo getNovelDetail(NovelDetailReqVo reqVo);
}