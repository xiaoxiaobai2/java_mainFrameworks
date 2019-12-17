package com.zhanghao.dao.impl;

import com.zhanghao.dao.AccountDao;
import com.zhanghao.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 持久层实现类
 */
@Component("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private JdbcTemplate template;

    public List<Account> findAll() {
        List<Account> accounts;
        try {
            String sql = "select * from account";
            accounts = template.query(sql,new BeanPropertyRowMapper<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return accounts;
    }

    public Account findById(int id) {
        List<Account> accounts;
        try {
            String sql = "select * from account where id=?";
            accounts = template.query(sql,new BeanPropertyRowMapper<Account>(Account.class),id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return accounts!=null?accounts.get(0):null;
    }

    public void update(Account account) {
        try {
            String sql = "update account set name = ?,money=? where id=?";
            template.update(sql,account.getName(),account.getMoney(),account.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }



    public Account findAccountByName(String name){
        List<Account> accounts;
        try {
            String sql = "select * from account where name=?";
            accounts = template.query(sql,new BeanPropertyRowMapper<Account>(Account.class),name);
            if (accounts==null||accounts.size()==0){
                return null;
            }
            if (accounts.size()>1){
                throw new RuntimeException();
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return accounts.get(0);
    }
}
