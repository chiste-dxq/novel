package com.chiste.novel.mapper.novel;

import com.chiste.novel.domain.novel.Novel;
import com.chiste.novel.domain.novel.vo.NovelAddVo;
import tk.mybatis.mapper.common.Mapper;

public interface NovelMapper extends Mapper<Novel> {
    int insertNovel(NovelAddVo addVo);
}