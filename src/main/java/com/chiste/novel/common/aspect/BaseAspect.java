package com.chiste.novel.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/*
 * @Author: daixq
 * @Date: 2021/4/7 17:23
 * @Description:
 **/
public class BaseAspect {

    /**
     * 是否存在注解，如果存在就获取
     * @return
     */
    public Annotation getAnnotationLog(JoinPoint joinPoint, Class cls) throws Exception {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null)
        {
            return method.getAnnotation(cls);
        }
        return null;
    }

}
