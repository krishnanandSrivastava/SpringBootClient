package com.example.clien.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.PostConstruct;

@RestController("/")
public class CheckCache {

    @Autowired CacheManager cacheManager;
    @Autowired CachingConfig cachingConfig;


    @PostConstruct public void init() {
        System.out.println("cacheManager------------------------------------------------------------hkjh");
        System.out.println(cacheManager.getCache("integers").get(1));
        
    }
    @GetMapping("check") 
    public String check() {
        cachingConfig.getIntegers(Math.random() > 0.5 ? 1 : 2);
        return cacheManager.getCache("integers").getNativeCache().toString();
    }
    
}
