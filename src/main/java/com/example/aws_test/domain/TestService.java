package com.example.aws_test.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TestService {
    private final TestRepository repository;
    private final StringRedisTemplate redisTemplate;

    public Map<String, String> test() {
        // 1. RDS 저장 및 조회
        Test saved = repository.save(new Test("Hello from RDS"));
        Test found = repository.findById(saved.getId()).orElseThrow();

        // 2. Redis 저장 및 조회
        redisTemplate.opsForValue().set("testKey", "Hello from Redis");
        String redisValue = redisTemplate.opsForValue().get("testKey");

        // 결과 반환
        Map<String, String> result = new HashMap<>();
        result.put("rds", found.getMessage());
        result.put("redis", redisValue);
        return result;
    }
}
