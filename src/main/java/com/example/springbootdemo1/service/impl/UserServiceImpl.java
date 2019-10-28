package com.example.springbootdemo1.service.impl;

import com.example.springbootdemo1.dao.RoleDao;
import com.example.springbootdemo1.dao.UserDao;
import com.example.springbootdemo1.entity.Role;
import com.example.springbootdemo1.entity.User;
import com.example.springbootdemo1.entity.UserDetail;
import com.example.springbootdemo1.exception.BusinessException;
import com.example.springbootdemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: PanJig
 * @date: 2019/10/28
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User addTestUser() {
        Role role = roleDao.findByName("test");
        if (role == null) {
            role = new Role();
            role.setName("test");
            role.setText("测试");
            roleDao.save(role);
        }
        User user = userDao.findByUsername("test");
        if (user == null) {
            user = new User();
            user.setUsername("test");
            user.setRole(role);
            user.setPassword(new BCryptPasswordEncoder().encode("123456"));
            userDao.save(user);
        }
        return user;
    }

    @Override
    public UserDetail login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new BusinessException("用户不存在");
        }
        Authentication authenticator = authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authenticator);
        return (UserDetail) authenticator.getPrincipal();
    }

    private Authentication authenticate(String username, String password) {
        try {
            // 该方法会去调用userDetailsService.loadUserByUsername()去验证用户名和密码，如果正确，则存储该用户名密码到“security
            // 的 context中”
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException | BadCredentialsException e) {
            throw new BusinessException("登录失败");
        }
    }
}
