package com.zhanghao.dao.impl;

import com.zhanghao.dao.AccountDao;
import com.zhanghao.domain.Account;
import com.zhanghao.utils.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 持久层实现类
 */
//注解持久层
@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAll() {
        List<Account> accounts;
        try {
            String sql = "select * from account";
            accounts = runner.query(sql, new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return accounts;
    }

    public Account findById(int id) {
        Account account;
        try {
            String sql = "select * from account where id=?";
            account = runner.query(sql,new BeanHandler<Account>(Account.class),id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return account;
    }

    public void update(Account account) {
        try {
            String sql = "update account set name = ?,money=? where id=?";
            runner.update(sql,account.getName(),account.getMoney(),account.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void insert(Account account) {
        try {
            String sql = "insert into account(name,money) values(?,?)";
            runner.update(sql,account.getName(),account.getMoney());
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public void delete(int id) {
        try {
            String sql = "delete from account where id=?";
            runner.update(sql,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
