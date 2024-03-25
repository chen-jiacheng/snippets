package com.chenjiacheng.snippets.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by chenjiacheng on 2024/2/5 20:42
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@MapperScan("com.chenjiacheng.snippets.sharding.dao.mapper")
@SpringBootApplication(scanBasePackages = "com.chenjiacheng.snippets.sharding")
public class ShardingJdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcApplication.class, args);
    }
}