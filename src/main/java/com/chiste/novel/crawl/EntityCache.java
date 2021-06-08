package com.chiste.novel.crawl;

import com.chiste.novel.domain.novel.vo.NovelAddVo;

/*
 * @Author: daixq
 * @Date: 2021/5/17 17:43
 * @Description:
 **/
public class EntityCache {
    /**
     * 保存的数据
     */
    private NovelAddVo datas;

    /**
     * 设置数据失效时间,为0表示永不失效
     */
    private long timeOut;

    /**
     * 最后刷新时间
     */
    private long lastRefreshTime;

    public EntityCache(NovelAddVo datas, long timeOut, long lastRefreshTime) {
        this.datas = datas;
        this.timeOut = timeOut;
        this.lastRefreshTime = lastRefreshTime;
    }
    public NovelAddVo getDatas() {
        return datas;
    }

    public void setDatas(NovelAddVo datas) {
        this.datas = datas;
    }

    public long getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }

    public long getLastRefreshTime() {
        return lastRefreshTime;
    }

    public void setLastRefreshTime(long lastRefreshTime) {
        this.lastRefreshTime = lastRefreshTime;
    }

}


