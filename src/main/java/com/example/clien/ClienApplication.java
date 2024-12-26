package com.example.clien;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class ClienApplication {

	

	public static void main(String[] args) {
		SpringApplication.run(ClienApplication.class, args);
		
	}

}
