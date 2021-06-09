package com.chiste.novel.controller.novel;

import com.chiste.novel.common.base.ResultMap;
import com.chiste.novel.common.util.ResultUtils;
import com.chiste.novel.domain.novel.vo.NovelCatReqVo;
import com.chiste.novel.domain.novel.vo.NovelListReqVo;
import com.chiste.novel.service.novel.NovelCatService;
import com.chiste.novel.service.novel.NovelService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/6/4 16:22
 * @Description:
 **/
@RestController
@RequestMapping("/api/novelCat")
public class NovelCatController {

    @Resource
    private NovelCatService novelCatService;
    @Resource
    private NovelService novelService;

    @PostMapping("/queryNovelCat")
    public ResultMap queryNovelCat(){
        List<NovelCatReqVo> newList = new ArrayList<>();
        List<NovelCatReqVo> list = novelCatService.queryNovelCat();
        for(NovelCatReqVo vo :list){
            NovelListReqVo reqVo = new NovelListReqVo();
            reqVo.setCatIds(vo.getId()+"");
            vo.setNovelListReqVo(novelService.queryNovel(reqVo));
            newList.add(vo);
        }
        return ResultUtils.success(newList);
    }
}
