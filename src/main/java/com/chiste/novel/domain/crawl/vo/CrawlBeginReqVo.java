package com.chiste.novel.domain.crawl.vo;

import com.chiste.novel.domain.novel.RuleBean;
import lombok.Data;


/*
 * @Author: daixq
 * @Date: 2021/4/26 11:54
 * @Description:
 **/
@Data
public class CrawlBeginReqVo {

    private Integer catId;

    private Integer sourceId;
}
