package com.example.redis_code_snippets;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

@Configuration
public class CacheConfig {

    public final static String BYTE_DATA = "byteData";
    public final static String STRING_DATA = "stringData";

    public enum CacheConstant {
        BYTE_DATA(CacheConfig.BYTE_DATA, Duration.ofSeconds(30)),
        STRING_DATA(CacheConfig.STRING_DATA, Duration.ofSeconds(30));

        private final String value;
        private final Duration ttl;

        CacheConstant(String value, Duration ttl) {
            this.value = value;
            this.ttl = ttl;
        }
    }

    @Bean
    public CacheManager customCacheManager(RedisConnectionFactory redisConnectionFactory) {
        RedisCacheManager.RedisCacheManagerBuilder redisCacheManagerBuilder =
                RedisCacheManager.builder(redisConnectionFactory);

        for (CacheConstant cacheConstant: CacheConstant.values()) {
            RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
            redisCacheManagerBuilder.withCacheConfiguration(cacheConstant.value,
                    redisCacheConfiguration.entryTtl(cacheConstant.ttl));
        }

        return redisCacheManagerBuilder.build();
    }

}
