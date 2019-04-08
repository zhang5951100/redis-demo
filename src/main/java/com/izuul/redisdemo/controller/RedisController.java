package com.izuul.redisdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/set/{key}/{value}")
    public String set(@PathVariable String key, @PathVariable String value) {
        redisTemplate.opsForValue().set(key, value,10, TimeUnit.SECONDS);
        return "Redis 添加成功 key{" + key + "} value{" + value + "}";
    }

    @GetMapping("/get/{key}")
    public String get(@PathVariable String key) {
        String value = redisTemplate.opsForValue().get(key);
        return "value{" + value + "}";
    }
}
