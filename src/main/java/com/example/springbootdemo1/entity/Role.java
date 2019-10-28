package com.example.springbootdemo1.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author: PanJig
 * @date: 2019/10/28
 */
@Data
@Entity
public class Role implements Serializable {
    private static final long serialVersionUID = 7656132837423214255L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 角色
     */
    private String name;

    /**
     * 角色名
     */
    private String text;
}
