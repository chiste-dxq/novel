package com.chiste.novel.domain.novel.vo;

import lombok.Data;

import javax.persistence.Column;

/*
 * @Author: daixq
 * @Date: 2021/6/9 11:13
 * @Description:
 **/
@Data
public class NovelListResVo {
    private Integer id;

    private String title;

    private String introduction;

    private String auditor;

    private Integer isDelete;

    private Integer type;

}
