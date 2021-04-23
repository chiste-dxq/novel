package com.chiste.novel.common.aspect;

import com.chiste.novel.common.annotion.Log;
import com.chiste.novel.domain.log.SysLogs;
import com.chiste.novel.service.log.SysLogsService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/*
 * @Author: daixq
 * @Date: 2021/4/2 14:34
 * @Description:
 **/
@Aspect
@Component
public class LogAspect extends BaseAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Resource
    private SysLogsService sjSysLogsService;

    /** 排除敏感属性字段 */
    public static final String[] EXCLUDE_PROPERTIES = { "password", "oldPassword", "newPassword", "confirmPassword" };

    // 配置织入点
    @Pointcut("@annotation(com.chiste.novel.common.annotion.Log)")
    public void logPointCut() { }

    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
        handleLog(joinPoint, null, jsonResult);
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     * @param e 异常
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e)
    {
        handleLog(joinPoint, e, null);
    }

    protected void handleLog(final JoinPoint joinPoint, final Exception e, Object jsonResult) {
        try {

            Log controllerLog = (Log) getAnnotationLog(joinPoint,Log.class);
            if (controllerLog == null)
            {
                return;
            }
            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            SysLogs sysLogs = new SysLogs();
            sysLogs.setClassName(className);
            sysLogs.setFunction(methodName);
            sysLogs.setIp(System.getProperties().getOrDefault("url","0.0.0.0").toString());
            getControllerMethodDescription(controllerLog,sysLogs);
            sjSysLogsService.insert(sysLogs);
        } catch (Exception exp) {
            // 记录本地异常日志
            log.error("==前置通知异常==");
            log.error("异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        }
    }
    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param log 日志
     * @param operLog 操作日志
     * @throws Exception
     */
    public void getControllerMethodDescription(Log log, SysLogs operLog) throws Exception {
        operLog.setMessage(log.title());
        operLog.setType(log.businessType().ordinal());
    }

}
