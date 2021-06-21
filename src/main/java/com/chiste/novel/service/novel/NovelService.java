package com.chiste.novel.service.novel;

import com.chiste.novel.domain.novel.Novel;
import com.chiste.novel.domain.novel.vo.*;

import java.util.List;

public interface NovelService {

    int insert(Novel novel);

    int insertNovel(NovelAddVo addVo);

    List<NovelListResVo> queryNovel(NovelListReqVo reqVo);

    NovelChapterResVo getNovelOne(Integer id);

    NovelDetailResVo getNovelDetail(NovelDetailReqVo reqVo);
}
