package com.example.redis_code_snippets;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Service
public class TestService {

    @Cacheable(value = CacheConfig.BYTE_DATA, cacheManager = "customCacheManager", unless = "#result == null")
    public byte[] getByteData() {
        try {
            Thread.sleep(3000); // sleep for 3 seconds
            return new byte[]{0, 0, 0, 0};
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Cacheable(value = CacheConfig.STRING_DATA, cacheManager = "customCacheManager", unless = "#result == null")
    public TestData getTestData() {
        try {
            Thread.sleep(3000);
            return new TestData("test", "data");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
