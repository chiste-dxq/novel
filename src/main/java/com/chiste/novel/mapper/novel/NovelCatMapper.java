package com.chiste.novel.mapper.novel;

import com.chiste.novel.domain.novel.NovelCat;
import tk.mybatis.mapper.common.Mapper;

public interface NovelCatMapper extends Mapper<NovelCat> {

    NovelCat findNovelCatByName(String name);
}