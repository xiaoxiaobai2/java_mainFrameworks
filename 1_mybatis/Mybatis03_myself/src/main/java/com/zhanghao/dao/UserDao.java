package com.zhanghao.dao;

import com.zhanghao.domain.User;
import com.zhanghao.mybatis.annotation.Select;

import java.util.List;

public interface UserDao {
    @Select("select * from user")
    List<User> findAll();
    @Select("select * from user where uid=?")
    List<User> findById(int id);

}
