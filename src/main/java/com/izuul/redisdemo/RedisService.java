package com.izuul.redisdemo;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisService {


    @Cacheable(value = "TEST", key = "#key")
    public String cacheAble(String key) {
        return getCache(key);
    }

    public String getCache(String key) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return key;
    }

}
