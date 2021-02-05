package com.example.shiro.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

/**
 * Author: YinJiaqi
 * Date: 10/12/2020 1:29 PM
 * Content:
 */
@Data
@AllArgsConstructor
public class User implements Serializable {
    private String id;
    private String userName;
    private String password;
    /**
     * 用户对应的角色集合
     */
    private Set<Role> role;
}
