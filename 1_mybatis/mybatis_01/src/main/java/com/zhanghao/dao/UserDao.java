package com.zhanghao.dao;

import com.zhanghao.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
}
