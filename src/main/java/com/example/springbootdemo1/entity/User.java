package com.example.springbootdemo1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @author: PanJig
 * @date: 2019/10/28
 */
@Data
@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 8551298415030317654L;

    /**
     * 自增ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @Length(min = 4, max = 20)
    @Pattern.List({ @Pattern(regexp = "^[0-9a-zA-Z_\\u4e00-\\u9fa5]+$"), @Pattern(regexp = "^.*[^\\d].*$") })
    @Column(nullable = false, updatable = false)
    private String username;

    /**
     * 密码
     */
    @Column(nullable = false)
    @JsonIgnore
    private String password;

    /**
     * 角色
     */
    @OneToOne(fetch = FetchType.EAGER)
    private Role role;
}
