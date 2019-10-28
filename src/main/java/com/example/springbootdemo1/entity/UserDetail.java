package com.example.springbootdemo1.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author: PanJig
 * @date: 2019/10/28
 */
public class UserDetail implements UserDetails {

    private static final long serialVersionUID = 7940895488344947173L;

    @Setter
    @Getter
    private String username;

    @Setter
    @Getter
    private String password;

    @Setter
    @Getter
    private Role role;

    @Setter
    @Getter
    private Date lastPasswordResetDate;

    public UserDetail(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * 分配给用户的角色列表
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getName()));
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
