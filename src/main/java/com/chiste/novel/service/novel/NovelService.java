package com.chiste.novel.service.novel;

import com.chiste.novel.domain.novel.Novel;
import com.chiste.novel.domain.novel.vo.NovelAddVo;

public interface NovelService {

    int insert(Novel novel);

    int insertNovel(NovelAddVo addVo);
}
