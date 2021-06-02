package com.chiste.novel.mapper.novel;

import com.chiste.novel.domain.novel.NovelContent;
import tk.mybatis.mapper.common.Mapper;

public interface NovelContentMapper extends Mapper<NovelContent> {
    int insertContent(NovelContent content);
}