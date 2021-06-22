package com.chiste.novel.service.novel.impl;

import com.chiste.novel.domain.novel.NovelContent;
import com.chiste.novel.domain.novel.vo.NovelChapterResVo;
import com.chiste.novel.domain.novel.vo.NovelContentAddVo;
import com.chiste.novel.domain.novel.vo.NovelContentListReqVo;
import com.chiste.novel.mapper.novel.NovelContentMapper;
import com.chiste.novel.service.novel.NovelContentService;
import com.chiste.novel.service.novel.NovelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/5/31 9:59
 * @Description:
 **/
@Service
public class NovelContentServiceImpl implements NovelContentService {

    @Resource
    NovelContentMapper novelContentMapper;
    @Resource
    NovelService novelService;

    @Override
    public int insertContent(NovelContent content) {
        return novelContentMapper.insertContent(content);
    }

    @Override
    public int batchInsertNovelContent(List<NovelContentAddVo> list) {
        int count = 0;
        int startIndex = 0;
        int endIndex;

        //limit标识，每次截取10个
        int limit = 10;
        int size = list.size();

        //每次截取的开始位置小于总长度，才会继续执行
        while (startIndex < size) {
            //尾部的位置
            endIndex = startIndex + limit;
            //尾部位置不能超出范围，否则就取集合的长度
            endIndex = endIndex > size ? size : endIndex;
            //截取
            List<NovelContentAddVo> subList = list.subList(startIndex, endIndex);
            novelContentMapper.batchInsertNovelContent(subList);
            //计算下次截取的开始位置
            startIndex = endIndex;

        }
        return count;
    }

    @Override
    public NovelChapterResVo queryContentByNovelId(NovelContentListReqVo reqVo) {
        NovelChapterResVo resVo = novelService.getNovelOne(reqVo.getId());
        resVo.setContents(novelContentMapper.queryContentByNovelId(reqVo));
        return resVo;
    }

    @Override
    public NovelContent getContentById(String id,String chapterId) {
        return novelContentMapper.getContentById(id,chapterId);
    }
}
