package com.chiste.novel.common.jwt;

import com.chiste.novel.domain.user.SysUser;
import com.chiste.novel.service.user.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/*
 * @Author: daixq
 * @Date: 2021/4/23 14:03
 * @Description:
 **/
@Slf4j
@Component
public class JwtRealm extends AuthorizingRealm {

    @Resource
    private SysUserService sysUserService;
    /*
     * 多重写一个support
     * 标识这个Realm是专门用来验证JwtToken
     * 不负责验证其他的token（UsernamePasswordToken）
     * */
    @Override
    public boolean supports(AuthenticationToken token) {
        //这个token就是从过滤器中传入的jwtToken
        return token instanceof JwtToken;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String  username = (String) principals.getPrimaryPrincipal();
        //这里从redis获取用户信息
        SysUser user = sysUserService.selectUserByCode(username);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        return simpleAuthorizationInfo;
    }

    //认证
    //这个token就是从过滤器中传入的jwtToken
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String token = (String) authenticationToken.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String userCode = null;
        try {
            //这里工具类没有处理空指针等异常这里处理一下(这里处理科学一些)
            userCode = JwtUtils.getUsername(token);
        } catch (Exception e) {
            throw new AuthenticationException("heard的token拼写错误或者值为空");
        }
        if (userCode == null) {
            log.error("token无效(空''或者null都不行!)");
            throw new AuthenticationException("token无效");
        }
        SysUser userBean = sysUserService.selectUserByCode(userCode);
        if (userBean == null) {
            log.error("用户不存在!)");
            throw new AuthenticationException("用户不存在!");
        }
        if (!JwtUtils.isVerify(token, userCode, userBean.getPassword())) {
            log.error("用户名或密码错误(token无效或者与登录者不匹配)!)");
            throw new AuthenticationException("用户名或密码错误(token无效或者与登录者不匹配)!");
        }
        return new SimpleAuthenticationInfo(token, token, "JwtRealm");


    }
}
