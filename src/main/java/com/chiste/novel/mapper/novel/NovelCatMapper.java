package com.chiste.novel.mapper.novel;

import com.chiste.novel.domain.novel.NovelCat;
import com.chiste.novel.domain.novel.vo.NovelCatReqVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NovelCatMapper extends Mapper<NovelCat> {

    NovelCat findNovelCatByName(String name);

    List<NovelCatReqVo> queryNovelCat();
}