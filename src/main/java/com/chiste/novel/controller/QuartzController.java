package com.chiste.novel.controller;

import com.chiste.novel.common.base.ResultMap;
import com.chiste.novel.common.job.DataJob;
import com.chiste.novel.common.util.DateUtils;
import com.chiste.novel.common.util.ResultUtils;
import com.chiste.novel.domain.QuartzReqVo;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.web.bind.annotation.*;

/*
 * @Author: daixq
 * @Date: 2021/5/28 10:37
 * @Description:
 **/
@RestController
@RequestMapping("/api/quartz")
public class QuartzController {

    @PostMapping("/scheduler")
    public ResultMap scheduler(@RequestBody QuartzReqVo vo){
        // 1、创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = null;
        try {
            scheduler = schedulerFactory.getScheduler();
            // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
            JobDetail jobDetail = JobBuilder.newJob(DataJob.class)
                    .withIdentity("job1", "group1").build();
            // 3、构建Trigger实例,每隔1s执行一次
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                    .startNow()//立即生效
                    .withSchedule(CronScheduleBuilder.cronSchedule(DateUtils.getCron(vo.getDate()))).build();//指定时间
            //4、执行
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return ResultUtils.success();
    }
}
