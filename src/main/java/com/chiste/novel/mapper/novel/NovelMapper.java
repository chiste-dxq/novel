package com.chiste.novel.mapper.novel;

import com.chiste.novel.domain.novel.Novel;
import com.chiste.novel.domain.novel.vo.NovelAddVo;
import com.chiste.novel.domain.novel.vo.NovelListReqVo;
import com.chiste.novel.domain.novel.vo.NovelListResVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NovelMapper extends Mapper<Novel> {
    int insertNovel(NovelAddVo addVo);

    List<NovelListResVo> queryNovel(NovelListReqVo reqVo);
}