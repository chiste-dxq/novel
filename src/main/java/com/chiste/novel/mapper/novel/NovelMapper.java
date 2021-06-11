package com.chiste.novel.mapper.novel;

import com.chiste.novel.domain.novel.Novel;
import com.chiste.novel.domain.novel.vo.NovelAddVo;
import com.chiste.novel.domain.novel.vo.NovelChapterResVo;
import com.chiste.novel.domain.novel.vo.NovelListReqVo;
import com.chiste.novel.domain.novel.vo.NovelListResVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NovelMapper extends Mapper<Novel> {
    int insertNovel(NovelAddVo addVo);

    List<NovelListResVo> queryNovel(NovelListReqVo reqVo);

    NovelChapterResVo getNovelOne(@Param("id") Integer id);
}