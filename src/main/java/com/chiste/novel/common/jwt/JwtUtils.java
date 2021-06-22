package com.chiste.novel.common.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/*
 * @Author: daixq
 * @Date: 2021/4/23 11:28
 * @Description:
 **/
@Slf4j
public class JwtUtils {

    /**
     * JWT验证过期时间 EXPIRE_TIME 分钟
     */
    private static final long EXPIRE_TIME = 30 * 60 * 1000;


    public static String getToken(String userCode, String password) {
        String token="";
        token= JWT.create().withAudience(userCode)
                .sign(Algorithm.HMAC256(password));
        return token;
    }

    /**
     *这里就是产生jwt字符串的地方
     * jwt字符串包括三个部分
     *  1. header
     *      -当前字符串的类型，一般都是“JWT”
     *      -哪种算法加密，“HS256”或者其他的加密算法
     *      所以一般都是固定的，没有什么变化
     *  2. payload
     *      一般有四个最常见的标准字段（下面有）
     *      iat：签发时间，也就是这个jwt什么时候生成的
     *      jti：JWT的唯一标识
     *      iss：签发人，一般都是username或者userId
     *      exp：过期时间
     **/
    public static String encode(String userCode, String password, Map<String, Object> claims) {
        //iss签发人，ttlMillis生存时间，claims是指还想要在jwt中存储的一些非隐私信息
        if (claims == null) {
            claims = new HashMap<>();
        }
        long nowMillis = System.currentTimeMillis();
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(password);
        // 附带username信息
        return JWT.create()
                .withClaim("userCode", userCode)
                // TODO: 2021/4/26 开发阶段token不设置过期时间，方便开发，后期设置 
//                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * 判断jwtToken是否合法
     * @param token
     * @param username
     * @param secret
     * @return
     */
    public static boolean isVerify(String token, String username, String secret) {
        try {
            //根据密码生成JWT效验器
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("userCode", username)
                    .build();
            //效验TOKEN
            DecodedJWT jwt = verifier.verify(token);
            log.info("登录验证成功!");
            return true;
        } catch (Exception exception) {
            log.error("JwtUtil登录验证失败!");

            return false;
        }
    }


    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userCode").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
