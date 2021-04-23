package com.chiste.novel.service.user;

import com.chiste.novel.domain.user.SysUser;

/*
 * @Author: daixq
 * @Date: 2021/4/20 10:08
 * @Description:
 **/
public interface SysUserService {
    int save(SysUser sysUser);

    SysUser selectUserById(Long userId);

    SysUser selectUserByCode(String userCode);
}
