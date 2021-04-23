package com.chiste.novel.mapper.log;

import com.chiste.novel.domain.log.SysLogs;
import com.chiste.novel.domain.log.SysLogsListVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysLogsMapper extends Mapper<SysLogs> {
    List<SysLogs> querySysLogs(SysLogsListVO logs);

     int insert(SysLogs sysLogs);
}