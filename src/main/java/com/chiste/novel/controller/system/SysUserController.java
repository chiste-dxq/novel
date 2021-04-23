package com.chiste.novel.controller.system;

import com.chiste.novel.common.base.BaseController;
import com.chiste.novel.common.base.ResultMap;
import com.chiste.novel.common.util.ResultUtils;
import com.chiste.novel.domain.user.SysUser;
import com.chiste.novel.service.user.SysUserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*
 * @Author: daixq
 * @Date: 2021/4/21 17:10
 * @Description:
 **/
@Slf4j
@Api(tags = "用户管理", value = "用户管理接口")
@RestController
@RequestMapping("/api/user")
public class SysUserController extends BaseController {

    @Resource
    private SysUserService sysUserService;

    @PostMapping("/save")
    public ResultMap save(@RequestBody SysUser user){
        return ResultUtils.success(sysUserService.save(user));
    }
}
