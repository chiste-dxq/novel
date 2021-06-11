package com.chiste.novel.controller.novel;

import com.chiste.novel.common.base.ResultMap;
import com.chiste.novel.common.util.ResultUtils;
import com.chiste.novel.domain.novel.vo.NovelChapterResVo;
import com.chiste.novel.domain.novel.vo.NovelContentListReqVo;
import com.chiste.novel.domain.novel.vo.NovelContentListResVo;
import com.chiste.novel.service.novel.NovelContentService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/6/11 15:44
 * @Description:
 **/
@RestController
@RequestMapping("/api/novelContent")
@Api(tags = "小说内容管理" ,value = "小说内容管理接口")
public class NovelContentController {

    @Resource
    private NovelContentService novelContentService;

    @PostMapping("/queryChapter")
    public ResultMap<NovelChapterResVo> queryChapter(@RequestParam("id") Integer id){
        NovelContentListReqVo reqVo = new NovelContentListReqVo();
        reqVo.setId(id);
        return ResultUtils.success(novelContentService.queryContentByNovelId(reqVo));
    }
}
