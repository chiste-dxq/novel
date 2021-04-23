package com.chiste.novel.service.role.impl;

import com.chiste.novel.domain.role.SysRole;
import com.chiste.novel.mapper.role.SysRoleMapper;
import com.chiste.novel.service.role.SysRoleService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/*
 * @Author: daixq
 * @Date: 2021/4/20 10:09
 * @Description:
 **/
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public SysRole querySysRole(){
        Example example = new Example(SysRole.class);
        example.createCriteria().andEqualTo("id", 1);
        SysRole sysRole = sysRoleMapper.selectOneByExample(example);
        return sysRole;
    }
}
