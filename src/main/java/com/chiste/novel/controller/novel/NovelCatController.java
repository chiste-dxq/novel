package com.chiste.novel.controller.novel;

import com.chiste.novel.common.base.ResultMap;
import com.chiste.novel.common.util.ResultUtils;
import com.chiste.novel.service.novel.NovelCatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @PostMapping("/queryNovelCat")
    public ResultMap queryNovelCat(){
        return ResultUtils.success(novelCatService.queryNovelCat());
    }
}
