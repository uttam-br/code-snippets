package com.example.redis_code_snippets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping(value = "/byte-data")
    public ResponseEntity<?> getByteData() {
        byte[] byteData = testService.getByteData();
        return ResponseEntity.ok(byteData);
    }

    @GetMapping(value = "/string-data")
    public ResponseEntity<?> getStringData() {
        TestData testData = testService.getTestData();
        return ResponseEntity.ok(testData);
    }

}
