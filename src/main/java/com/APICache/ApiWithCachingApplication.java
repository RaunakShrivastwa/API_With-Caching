package com.APICache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiWithCachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiWithCachingApplication.class, args);
		System.out.println("Project Running....");
	}

}
