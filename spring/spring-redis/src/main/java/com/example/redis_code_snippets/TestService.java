package com.example.redis_code_snippets;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;

@Service
public class TestService {

    @Cacheable(value = "testdata", cacheManager = "cacheManager")
    public byte[] getTestData() {
        try {
            Thread.sleep(3000); // sleep for 3 seconds
//            return new TestData("Uttam", "Rabari");
            byte[] bytes = new byte[]{0, 0, 0, 0};
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
