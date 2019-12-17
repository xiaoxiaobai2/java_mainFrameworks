package com.zhanghao.dao.impl;

import com.zhanghao.dao.AccountDao;
import com.zhanghao.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

/**
 * 持久层实现类
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    public List<Account> findAll() {
        String sql = "select * from account";
        return getTemplate().query(sql,new BeanPropertyRowMapper<Account>(Account.class));
    }

    public Account findById(int id) {
        String sql = "select * from account where id = ?";
        List<Account> accounts = getTemplate().query(sql, new BeanPropertyRowMapper<Account>(Account.class), id);
        return accounts!=null?accounts.get(0):null;
    }
}
