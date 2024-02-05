package com.chenjiacheng.snippets.sharding.dao.mapper;

import com.chenjiacheng.snippets.sharding.SnippetsShardingApplicationTest;
import com.chenjiacheng.snippets.sharding.dao.model.User;
import com.chenjiacheng.snippets.sharding.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chenjiacheng on 2024/2/5 23:04
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public class UserMapperTest extends SnippetsShardingApplicationTest {

    @Autowired
    private UserService userService;

    @Test
    void insertUser() {
        User user1 = new User(null,"张三",15,"男");
        User user2 = new User(null,"李四",20,"女");

        userService.insertUser(user1);
        userService.insertUser(user2);
    }

    @Test
    void getUserById() {
    }
}