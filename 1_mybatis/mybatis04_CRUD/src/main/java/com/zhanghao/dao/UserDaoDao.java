package com.zhanghao.dao;

import com.zhanghao.domain.User;

import java.util.List;

public interface UserDaoDao {
    /**
     * 查询所有
     * @return
     */
    List<User> findAll();
}
