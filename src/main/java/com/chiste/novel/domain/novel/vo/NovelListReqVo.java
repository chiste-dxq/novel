package com.chiste.novel.domain.novel.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/*
 * @Author: daixq
 * @Date: 2021/6/9 11:09
 * @Description:
 **/
@Data
public class NovelListReqVo {
    @ApiModelProperty("分类id")
    private String catIds;
    @ApiModelProperty("书名")
    private String title;
    @ApiModelProperty("作者")
    private String auditor;
}
