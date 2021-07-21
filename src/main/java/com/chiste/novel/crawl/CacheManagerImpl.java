package com.chiste.novel.crawl;

import com.chiste.novel.domain.novel.vo.NovelAddVo;
import com.chiste.novel.domain.novel.vo.NovelContentAddVo;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/*
 * @Author: daixq
 * @Date: 2021/5/17 17:42
 * @Description:a
 **/
public class CacheManagerImpl implements ICacheManager {
    private static Map<String, EntityCache> caches = new ConcurrentHashMap<String, EntityCache>();

    /**
     * 存入缓存
     * @param key
     * @param cache
     */
    public void putCache(String key, EntityCache cache) {
        caches.put(key, cache);
    }

    /**
     * 存入缓存
     * @param key
     * @param datas
     * @param timeOut
     */
    public void putCache(String key, NovelAddVo datas, long timeOut) {
        timeOut = timeOut > 0 ? timeOut : 0L;
        putCache(key, new EntityCache(datas, timeOut, System.currentTimeMillis()));
    }

    /**
     * 获取对应缓存
     * @param key
     * @return
     */
    public EntityCache getCacheByKey(String key) {
        if (this.isContains(key)) {
            return caches.get(key);
        }
        return null;
    }

    /**
     * 获取对应缓存
     * @param key
     * @return
     */
    public Object getCacheDataByKey(String key) {
        if (this.isContains(key)) {
            return caches.get(key).getDatas();
        }
        return null;
    }

    /**
     * 获取所有缓存
     * @return
     */
    public Map<String, EntityCache> getCacheAll() {
        return caches;
    }

    /**
     * 判断是否在缓存中
     * @param key
     * @return
     */
    public boolean isContains(String key) {
        return caches.containsKey(key);
    }

    /**
     * 清除所有缓存
     */
    public void clearAll() {
        caches.clear();
    }

    /**
     * 清除对应缓存
     * @param key
     */
    public void clearByKey(String key) {
        if (this.isContains(key)) {
            caches.remove(key);
        }
    }

    /**
     * 缓存是否超时失效
     * @param key
     * @return
     */
    public boolean isTimeOut(String key) {
        if (!caches.containsKey(key)) {
            return true;
        }
        EntityCache cache = caches.get(key);
        long timeOut = cache.getTimeOut();
        long lastRefreshTime = cache.getLastRefreshTime();
        if (timeOut == 0 || System.currentTimeMillis() - lastRefreshTime >= timeOut) {
            return true;
        }
        return false;
    }

    /**
     * 获取所有key
     * @return
     */
    public Set<String> getAllKeys() {
        return caches.keySet();
    }
}


