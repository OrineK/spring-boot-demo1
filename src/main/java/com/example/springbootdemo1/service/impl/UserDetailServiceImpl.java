package com.example.springbootdemo1.service.impl;

import com.example.springbootdemo1.dao.UserDao;
import com.example.springbootdemo1.entity.User;
import com.example.springbootdemo1.entity.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author: PanJig
 * @date: 2019/10/28
 */
@Component("UserDetailServiceImpl")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        } else {
            return new UserDetail(user.getUsername(), user.getPassword(), user.getRole());
        }
    }
}
