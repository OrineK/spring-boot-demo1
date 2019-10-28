package com.example.springbootdemo1.dao;

import com.example.springbootdemo1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: PanJig
 * @date: 2019/10/28
 */
@Repository
public interface UserDao extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findByUsername(String username);

}
