package com.chiste.novel.service.novel.impl;

import com.chiste.novel.domain.novel.NovelContent;
import com.chiste.novel.mapper.novel.NovelContentMapper;
import com.chiste.novel.service.novel.NovelContentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
 * @Author: daixq
 * @Date: 2021/5/31 9:59
 * @Description:
 **/
@Service
public class NovelContentServiceImpl implements NovelContentService {

    @Resource
    NovelContentMapper novelContentMapper;

    @Override
    public int insertContent(NovelContent content) {
        return novelContentMapper.insertContent(content);
    }
}
