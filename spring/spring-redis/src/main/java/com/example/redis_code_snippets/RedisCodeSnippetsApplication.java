package com.example.redis_code_snippets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisCodeSnippetsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCodeSnippetsApplication.class, args);
	}

}
