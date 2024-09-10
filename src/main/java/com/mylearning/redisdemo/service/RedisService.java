package com.mylearning.redisdemo.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class RedisService {

    private final RedisTemplate<String , Object> redisTemplate;
    private final ObjectMapper objectMapper;


    public <T> T get(String key, Class<T> entityClass) {
//        return (T) redisTemplate.opsForValue().get(key);
        Object o = redisTemplate.opsForValue().get(key);
        try {
            if (o!=null) {
                return objectMapper.readValue(o.toString(), entityClass);
            }
        }catch (Exception e){
            log.error(e.getMessage());
            return null;
        }
        return null;
    }

    public void set(String key, Object value, Long ttl) {
        try {
            redisTemplate.opsForValue().set(key,value.toString(),ttl, TimeUnit.SECONDS);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    public <T> List<T> getList(String key, TypeReference<List<T>> typeReference) {
        try {
            Object o = redisTemplate.opsForValue().get(key);
            if (o != null) {
                // Deserialize the JSON string into the specified List<T>
                return objectMapper.readValue(o.toString(), typeReference);
            }
        } catch (Exception e) {
            log.error("Error while fetching list from Redis: {}", e.getMessage());
        }
        return null;
    }

    public <T> void setList(String key, List<T> value, Long ttl) {
        try {
            // Serialize the List into JSON and store it in Redis
            String jsonString = objectMapper.writeValueAsString(value);
            redisTemplate.opsForValue().set(key, jsonString, ttl, TimeUnit.SECONDS);
        } catch (Exception e) {
            log.error("Error while saving list to Redis: {}", e.getMessage());
        }
    }





}
