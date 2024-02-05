package com.chenjiacheng.snippets.sharding.controller;

import com.chenjiacheng.snippets.sharding.dao.model.User;
import com.chenjiacheng.snippets.sharding.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenjiacheng on 2024/2/5 21:07
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable("id")Long id){
        log.info("getUser - request - {}",id);
        User user = userService.getUser(id);
        log.info("getUser - response - {}",user);
        return ResponseEntity.ok(user);
    }

}
