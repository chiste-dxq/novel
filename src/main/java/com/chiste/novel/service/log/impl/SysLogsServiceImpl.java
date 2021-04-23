package com.chiste.novel.service.log.impl;

import com.chiste.novel.domain.log.SysLogs;
import com.chiste.novel.domain.log.SysLogsListVO;
import com.chiste.novel.mapper.log.SysLogsMapper;
import com.chiste.novel.service.log.SysLogsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/4/2 14:42
 * @Description:
 **/
@Service
public class SysLogsServiceImpl implements SysLogsService {

    @Resource
    private SysLogsMapper mapper;

    @Override
    public int insert(SysLogs sysLogs) {
        return mapper.insert(sysLogs);
    }

    @Override
    public List<SysLogs> querySjSysLogs(SysLogsListVO logs) {
        return mapper.querySysLogs(logs);
    }
}
