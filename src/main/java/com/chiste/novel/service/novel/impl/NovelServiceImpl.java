package com.chiste.novel.service.novel.impl;

import com.chiste.novel.common.util.DateUtils;
import com.chiste.novel.common.util.RandomValidateCodeUtils;
import com.chiste.novel.domain.novel.Novel;
import com.chiste.novel.domain.novel.NovelCat;
import com.chiste.novel.domain.novel.vo.NovelAddVo;
import com.chiste.novel.domain.novel.vo.NovelChapterResVo;
import com.chiste.novel.domain.novel.vo.NovelListReqVo;
import com.chiste.novel.domain.novel.vo.NovelListResVo;
import com.chiste.novel.mapper.novel.NovelCatMapper;
import com.chiste.novel.mapper.novel.NovelMapper;
import com.chiste.novel.service.novel.NovelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/4/21 17:19
 * @Description:
 **/
@Service
public class NovelServiceImpl implements NovelService {

    @Resource
    private NovelMapper novelMapper;
    @Resource
    private NovelCatMapper novelCatMapper;

    @Override
    public int insert(Novel novel) {
        NovelCat cat = novelCatMapper.findNovelCatByName(novel.getTypeString());
        if(cat==null){
            cat = new NovelCat();
            cat.setCatCode(RandomValidateCodeUtils.getRandomNum(2));
            cat.setCatName(novel.getTypeString());
            cat.setSort(1);
            cat.setCreateTime(DateUtils.getNow());
            cat.setUpdateTime(DateUtils.getNow());
            cat.setCreateUser(0);
            novelCatMapper.insert(cat);
        }
        novel.setType(cat.getId());
        return novelMapper.insert(novel);
    }

    @Override
    public int insertNovel(NovelAddVo addVo) {
        NovelCat cat = novelCatMapper.findNovelCatByName(addVo.getTypeString());
        if(cat==null){
            cat = new NovelCat();
            cat.setCatCode(RandomValidateCodeUtils.getRandomNum(2));
            cat.setCatName(addVo.getTypeString());
            cat.setSort(1);
            cat.setCreateTime(DateUtils.getNow());
            cat.setUpdateTime(DateUtils.getNow());
            cat.setCreateUser(0);
            novelCatMapper.insert(cat);
        }
        addVo.setType(cat.getId());
        return novelMapper.insertNovel(addVo);
    }

    @Override
    public List<NovelListResVo> queryNovel(NovelListReqVo reqVo) {
        return novelMapper.queryNovel(reqVo);
    }

    @Override
    public NovelChapterResVo getNovelOne(Integer id) {
        return novelMapper.getNovelOne(id);
    }
}
