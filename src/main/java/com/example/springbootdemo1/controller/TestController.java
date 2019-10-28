package com.example.springbootdemo1.controller;

import com.example.springbootdemo1.entity.User;
import com.example.springbootdemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: PanJig
 * @date: 2019/10/28
 */
@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("/test1")
    public String test1() {
        return "test1";
    }

    /**
     * 生成
     * 用户名 test
     * 密码   123456
     * 用户
     * @return
     */
    @GetMapping("/addTestUser")
    public String addTestUser() {
        User user = userService.addTestUser();
        user.setPassword("123456");
        return user.toString();
    }

    @GetMapping("/test2")
    public String test2() {
        return "test2";
    }
}
