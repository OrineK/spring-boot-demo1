package com.example.springbootdemo1.service;

import com.example.springbootdemo1.entity.User;
import com.example.springbootdemo1.entity.UserDetail;

/**
 * @author: PanJig
 * @date: 2019/10/28
 */
public interface UserService {

    User findByUsername(String username);

    User addTestUser();

    UserDetail login(String username, String password);
}
