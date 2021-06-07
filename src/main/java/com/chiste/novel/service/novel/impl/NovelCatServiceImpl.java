package com.chiste.novel.service.novel.impl;

import com.chiste.novel.domain.novel.NovelCat;
import com.chiste.novel.mapper.novel.NovelCatMapper;
import com.chiste.novel.service.novel.NovelCatService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/4/23 17:43
 * @Description:
 **/
@Service
public class NovelCatServiceImpl implements NovelCatService {

    @Resource
    private NovelCatMapper novelCatMapper;

    @Override
    public List<NovelCat> queryNovelCat() {
        return novelCatMapper.selectAll();
    }
}
