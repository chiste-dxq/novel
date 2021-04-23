package com.chiste.novel.common.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/*
 * @Author: daixq
 * @Date: 2021/4/21 17:10
 * @Description:
 **/
@Data
public class BaseVo {

    @ApiModelProperty("每页数量")
    private Integer pageSize;
    @ApiModelProperty("页码")
    private Integer page;

}
