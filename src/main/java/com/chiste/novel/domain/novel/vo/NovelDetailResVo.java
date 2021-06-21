package com.chiste.novel.domain.novel.vo;

import lombok.Data;

/*
 * @Author: daixq
 * @Date: 2021/6/21 17:05
 * @Description:
 **/
@Data
public class NovelDetailResVo {

    private String id;
    private String title;
    private String auditor;
    private String introduction;
    private String createTime;
    private String chapterNum;
    private String novelStatus;
}
