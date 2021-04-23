package com.chiste.novel.service.log;

import com.chiste.novel.domain.log.SysLogs;
import com.chiste.novel.domain.log.SysLogsListVO;

import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/4/2 14:41
 * @Description:
 **/
public interface SysLogsService {

    int insert(SysLogs sysLogs);

    List<SysLogs> querySjSysLogs(SysLogsListVO logs);
}
