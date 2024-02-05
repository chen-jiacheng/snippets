package com.chenjiacheng.snippets.sharding.service.impl;

import com.chenjiacheng.snippets.sharding.dao.mapper.UserMapper;
import com.chenjiacheng.snippets.sharding.dao.model.User;
import com.chenjiacheng.snippets.sharding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chenjiacheng on 2024/2/5 21:27
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
