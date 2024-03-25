package com.chenjiacheng.redis.jedis;

import com.chenjiacheng.redis.RedisApplicationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * Created by chenjiacheng on 2024/2/6 19:45
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public class JedisClientTest extends RedisApplicationTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void connectTest(){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        String value = ops.get("test");
        System.out.println("value = " + value);
    }

}
