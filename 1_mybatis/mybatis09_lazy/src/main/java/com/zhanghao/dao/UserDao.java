package com.zhanghao.dao;

import com.zhanghao.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有
     * @return
     */
    List<User> findAll();

    /**
     * 通过ID查找用户
     * @param id
     * @return
     */
    User findById(int id);


}
