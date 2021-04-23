package com.chiste.novel.domain.log;

import lombok.Data;

import java.util.Date;

/*
 * @Author: daixq
 * @Date: 2021/4/23 10:38
 * @Description:
 **/
@Data
public class SysLogsListVO {
    private int id;
    private String level;
    private String className;
    private String logger;
    private String message;
    private String function;
    private int type;
    private Date createDate;
    private String ip;
}
