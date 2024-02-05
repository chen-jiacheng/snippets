package com.chenjiacheng.snippets.sharding.service;

import com.chenjiacheng.snippets.sharding.dao.model.User;

/**
 * Created by chenjiacheng on 2024/2/5 21:26
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public interface UserService {
    User getUser(Long id);

    void insertUser(User user);
}
