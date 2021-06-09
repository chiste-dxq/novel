package com.chiste.novel.domain.novel.vo;
import lombok.Data;

import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/6/9 16:55
 * @Description:
 **/
@Data
public class NovelCatReqVo {
    private Integer id;

    private String catCode;

    private String catName;

    private Integer sort;

    private List<NovelListResVo> novelListReqVo;
}
