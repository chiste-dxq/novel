package com.chiste.novel.service.novel.impl;

import com.chiste.novel.domain.novel.Novel;
import com.chiste.novel.mapper.novel.NovelMapper;
import com.chiste.novel.service.novel.NovelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
 * @Author: daixq
 * @Date: 2021/4/21 17:19
 * @Description:
 **/
@Service
public class NovelServiceImpl implements NovelService {

    @Resource
    private NovelMapper novelMapper;

    @Override
    public int insert(Novel novel) {
        return novelMapper.insert(novel);
    }
}
