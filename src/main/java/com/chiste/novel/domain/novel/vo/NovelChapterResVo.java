package com.chiste.novel.domain.novel.vo;

import lombok.Data;

import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/6/11 16:30
 * @Description:
 **/
@Data
public class NovelChapterResVo {

    private Integer id;
    private String title;
    private String auditor;

    private List<NovelContentListResVo> contents;
}
