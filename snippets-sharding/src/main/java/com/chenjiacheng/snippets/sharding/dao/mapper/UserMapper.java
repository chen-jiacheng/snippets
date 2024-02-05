package com.chenjiacheng.snippets.sharding.dao.mapper;

import com.chenjiacheng.snippets.sharding.dao.model.User;

/**
 * Created by chenjiacheng on 2024/2/5 21:26
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public interface UserMapper {

    void insertUser(User user);
    User getUserById(Long id);

}
