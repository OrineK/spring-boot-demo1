package com.example.springbootdemo1.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo1.constant.Constant;
import com.example.springbootdemo1.constant.ResultCode;
import com.example.springbootdemo1.entity.User;
import com.example.springbootdemo1.entity.UserDetail;
import com.example.springbootdemo1.jwt.JwtUtil;
import com.example.springbootdemo1.service.UserService;
import com.example.springbootdemo1.service.impl.RedisService;
import com.example.springbootdemo1.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: PanJig
 * @date: 2019/10/28
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private RedisService redisService;

    @PostMapping("/login")
    public ResultUtil login(String username, String password) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return ResultUtil.error(ResultCode.FAIL, "用户不存在");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(password, user.getPassword())) {
            return ResultUtil.error(ResultCode.FAIL, "账号密码错误");
        }
        UserDetail userDetail = userService.login(user.getUsername(), password);
        String token = jwtUtil.generateToken(userDetail);
        redisService.setValue(userDetail.getUsername(), token, Constant.USER_LOGIN_EXPIRE_TIME);
        JSONObject tokenJson = new JSONObject();
        tokenJson.put("token", token);
        tokenJson.put("expire_time", Constant.USER_LOGIN_EXPIRE_TIME);
        System.out.println(user.getUsername() + " is logged in");
        return ResultUtil.ok(tokenJson);
    }
}
