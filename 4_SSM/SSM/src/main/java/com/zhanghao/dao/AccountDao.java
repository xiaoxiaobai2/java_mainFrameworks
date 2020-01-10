package com.zhanghao.dao;

import com.zhanghao.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层
 */
//@Repository("accountDao")
public interface AccountDao {

//    @Select("select * from account")
    List<Account> findAll();

//    @Insert("insert into account(name,money) values(#{name},#{money})")
    void save(Account account);
}
