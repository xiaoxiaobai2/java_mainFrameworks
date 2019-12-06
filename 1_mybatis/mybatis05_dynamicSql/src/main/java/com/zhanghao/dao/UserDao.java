package com.zhanghao.dao;

import com.zhanghao.domain.QueryVo;
import com.zhanghao.domain.User;

import java.util.List;

public interface UserDao {

    /**
     * 动态查询    按姓名 和uid   进行判断 拼接   where  if
     * @param user
     * @return
     */
    List<User> findByName(User user);

    /**
     * 动态查询  where if  each   子查询
     * @param queryVo
     * @return
     */
    List<User> findInUids(QueryVo queryVo);
}
