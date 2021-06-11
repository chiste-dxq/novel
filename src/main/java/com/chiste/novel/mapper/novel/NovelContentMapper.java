package com.chiste.novel.mapper.novel;

import com.chiste.novel.domain.novel.NovelContent;
import com.chiste.novel.domain.novel.vo.NovelContentAddVo;
import com.chiste.novel.domain.novel.vo.NovelContentListReqVo;
import com.chiste.novel.domain.novel.vo.NovelContentListResVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface NovelContentMapper extends Mapper<NovelContent> {
    int insertContent(NovelContent content);

    int batchInsertNovelContent(List<NovelContentAddVo> list);

    List<NovelContentListResVo> queryContentByNovelId(NovelContentListReqVo reqVo);
}