package com.zjut.azhen.ncov.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/*
 *编写RedisTemplate工具类
 */

public final class RedisUtil{
    @Resource
    private RedisTemplate <Object, Object> redisTemplate;

    //指定缓存失效时间
    public boolean expire(String key, long time){
        try{
            if(time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    //根据key值获取过期时间
    public long getExipre(String key){
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    //判断key值是否存在
    public boolean hasKey(String key){
        try{
            return redisTemplate.hasKey(key);
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    //删除缓存
    @SuppressWarnings("unchecked")
    public void del(String... key){
        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
            }
        }
    }

    //普通缓存获取
    public Object get(String key){
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    //普通缓存放入
    public boolean set(String key, Object value){
        try{
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    public boolean set(String key, Object value, long time){
        try{
            if(time > 0){
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            }
            else{
                set(key, value);
            }
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }



    /*
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }


    public long decr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }
    */
}



