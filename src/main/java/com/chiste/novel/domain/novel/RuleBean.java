package com.chiste.novel.domain.novel;

import lombok.Data;

import java.util.Map;

/*
 * @Author: daixq
 * @Date: 2021/4/26 9:53
 * @Description:
 **/
@Data
public class RuleBean {
    /**
     * 小说更新列表url
     * */
    private String updateBookListUrl;

    /**
     * 分类列表页URL规则
     * */
    private String bookListUrl;

    private Map<String,String> catUrlRule;

    private String bookIdPatten;
    private String pagePatten;
    private String totalPagePatten;
    private String bookDetailUrl;
    private String bookNamePatten;
    private String authorNamePatten;
    private String picUrlPatten;
    private String statusPatten;
    private String scorePatten;
    private String visitCountPatten;
    private String descStart;;
    private String descEnd;
    private String updateTimePatten;
    private String updateTimeFormatPatten;
    private String bookIndexUrl;
    private String picUrlPrefix;

    private String bookIndexStart;

    private String downloadUrlPatten;
    private String downloadUrl;
}
