package com.zhanghao.dao;

import com.zhanghao.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    @Select("select * from account")

    /**
     * 设置一对一  延时加载
     */
    @Results(@Result(column = "uid" ,property = "user",one = @One(select = "com.zhanghao.dao.UserDao.findById",fetchType = FetchType.EAGER)))
    List<Account> findAll();

    @Select("select * from account where uid=#{uid}")
    Account findByUid(int uid);
}
