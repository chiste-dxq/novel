package com.chiste.novel.common.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/*
 * @Author: daixq
 * @Date: 2021/4/23 14:12
 * @Description:
 **/
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}