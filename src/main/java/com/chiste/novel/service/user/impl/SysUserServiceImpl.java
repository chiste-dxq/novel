package com.chiste.novel.service.user.impl;

import com.chiste.novel.common.util.MD5Utils;
import com.chiste.novel.domain.user.SysUser;
import com.chiste.novel.mapper.user.SysUserMapper;
import com.chiste.novel.service.user.SysUserService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/*
 * @Author: daixq
 * @Date: 2021/4/20 10:09
 * @Description:
 **/
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    SysUserMapper userMapper;

    @Override
    public int save(SysUser sysUser) {
        sysUser.setPassword(MD5Utils.encrypt(sysUser.getUserCode(), sysUser.getPassword()));
        return userMapper.insert(sysUser);
    }

    @Override
    public SysUser selectUserById(Long userId) {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",userId);
        return userMapper.selectOneByExample(example);
    }

    @Override
    public SysUser selectUserByCode(String userCode) {
        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userCode",userCode);
        return userMapper.selectOneByExample(example);
    }
}
