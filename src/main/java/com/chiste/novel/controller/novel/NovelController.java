package com.chiste.novel.controller.novel;

import com.chiste.novel.common.base.ResultMap;
import com.chiste.novel.common.util.ResultUtils;
import com.chiste.novel.domain.novel.vo.NovelListReqVo;
import com.chiste.novel.domain.novel.vo.NovelListResVo;
import com.chiste.novel.service.novel.NovelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/6/4 16:22
 * @Description:
 **/
@RestController
@RequestMapping("/api/novel")
public class NovelController {

    @Resource
    private NovelService novelService;

    @PostMapping("/queryNovel")
    @ApiOperation("获取小说列表")
    public ResultMap<List<NovelListResVo>> queryNovel(NovelListReqVo reqVo){
        return ResultUtils.success(novelService.queryNovel(reqVo));
    }

}
