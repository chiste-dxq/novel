package com.chiste.novel.domain.novel.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/*
 * @Author: daixq
 * @Date: 2021/5/31 10:12
 * @Description:
 **/
@Data
public class NovelContentAddVo {

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("章节")
    private String chapter;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("小说id")
    private Integer novelId;
}
