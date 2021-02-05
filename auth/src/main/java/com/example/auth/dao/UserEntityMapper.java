package com.example.auth.dao;

import com.example.auth.entity.UserEntity;
import java.util.List;

public interface UserEntityMapper {
    List<UserEntity> selectAll();
}