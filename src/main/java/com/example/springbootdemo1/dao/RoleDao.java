package com.example.springbootdemo1.dao;

import com.example.springbootdemo1.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author: PanJig
 * @date: 2019/10/28
 */
@Repository
public interface RoleDao extends JpaRepository<Role, Long>, JpaSpecificationExecutor<Role> {

    Role findByName(String name);

}
