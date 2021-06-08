package com.chiste.novel.mapper.novel;

import com.chiste.novel.domain.novel.NovelContent;
import com.chiste.novel.domain.novel.vo.NovelContentAddVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NovelContentMapper extends Mapper<NovelContent> {
    int insertContent(NovelContent content);

    int batchInsertNovelContent(List<NovelContentAddVo> list);
}