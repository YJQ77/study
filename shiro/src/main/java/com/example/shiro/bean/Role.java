package com.example.shiro.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

/**
 * Author: YinJiaqi
 * Date: 10/12/2020 1:28 PM
 * Content:
 */
@Data
@AllArgsConstructor
public class Role {
    private String id;
    private String roleName;
    /**
     * 角色对应权限集合
     */
    private Set<Permissions> permissions;
}
