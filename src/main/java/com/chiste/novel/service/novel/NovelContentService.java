package com.chiste.novel.service.novel;

import com.chiste.novel.domain.novel.NovelContent;
import com.chiste.novel.domain.novel.vo.NovelContentAddVo;

import java.util.List;

public interface NovelContentService {
    int insertContent(NovelContent content);

    int batchInsertNovelContent(List<NovelContentAddVo> list);
}
