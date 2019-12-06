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
     * 增加一条新的记录
     * @param user
     */
    void insertUser(User user);
    void deleteById(int id);
    void update(String name,int age,int uid);
    User findById(int uid);


}
