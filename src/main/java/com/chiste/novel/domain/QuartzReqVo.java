package com.chiste.novel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/*
 * @Author: daixq
 * @Date: 2021/5/28 11:13
 * @Description:
 **/
@Data
public class QuartzReqVo {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    Date date;
}
