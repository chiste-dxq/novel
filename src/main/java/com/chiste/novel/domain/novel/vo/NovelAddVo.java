package com.chiste.novel.domain.novel.vo;

import com.chiste.novel.domain.novel.NovelContent;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/5/31 10:01
 * @Description:
 **/
@Data
public class NovelAddVo {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("简介")
    private String introduction;
    @ApiModelProperty("作者")
    private String auditor;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("创建人")
    private String createUser;
    @ApiModelProperty("更新时间")
    private Date updateTime;
    @ApiModelProperty("更新人")
    private String updateUser;
    @ApiModelProperty("来源1：系统；2：用户")
    private Integer source;
    @ApiModelProperty("是否删除")
    private Integer isDelete;
    @ApiModelProperty("类型")
    private Integer type;
    @ApiModelProperty("类型文字")
    private String typeString;
    @ApiModelProperty("下载地址")
    private String downloadUrl;
}
