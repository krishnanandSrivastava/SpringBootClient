package com.example.clien.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
@EnableCaching
public class CachingConfig {

    

    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(
        //   new ConcurrentMapCache("directory"), 
          new ConcurrentMapCache("integers"), 
          new ConcurrentMapCache("addresses")));
        return cacheManager;
    }

    @Cacheable(value = "integers", key = "#i")
	public List<Integer> getIntegers(int i){
    System.out.println("cacheManager---hkjh");
		return List.of(1,2,3);
	}
      
}