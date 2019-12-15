package com.neu.his.cloud.service.dms.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * redis操作Service的实现类
 */
@Service
public class RedisUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    public void setStr(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }


    public String getStr(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 设置超期时间
     */
    public boolean expireStr(String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }


    public void removeStr(String key) {
        stringRedisTemplate.delete(key);
    }


    public void removeObj(String key) {
        redisTemplate.delete(key);
    }


    public void setObj(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }


    public Object getObj(String key) {
        return redisTemplate.opsForValue().get(key);
    }




}
