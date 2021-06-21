package com.chiste.novel.service.novel;

import com.chiste.novel.domain.novel.NovelContent;
import com.chiste.novel.domain.novel.vo.NovelChapterResVo;
import com.chiste.novel.domain.novel.vo.NovelContentAddVo;
import com.chiste.novel.domain.novel.vo.NovelContentListReqVo;

import java.util.List;

public interface NovelContentService {
    int insertContent(NovelContent content);

    int batchInsertNovelContent(List<NovelContentAddVo> list);

    NovelChapterResVo queryContentByNovelId(NovelContentListReqVo reqVo);

    NovelContent getContentById(Integer id);
}
