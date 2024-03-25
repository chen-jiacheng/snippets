package com.chenjiacheng.snippets.sharding;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created by chenjiacheng on 2024/2/5 23:02
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@SpringBootTest
@MapperScan("com.chenjiacheng.snippets.sharding.dao.mapper")
public class ShardingJdbcApplicationTest {

    @Test
    public void contextLoads() {
    }
}