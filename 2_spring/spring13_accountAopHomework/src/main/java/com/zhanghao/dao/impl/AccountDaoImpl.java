package com.zhanghao.dao.impl;

import com.zhanghao.dao.AccountDao;
import com.zhanghao.domain.Account;
import com.zhanghao.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * 持久层实现类
 */
public class AccountDaoImpl implements AccountDao {

    private QueryRunner runner;

    private ConnectionUtils connection;

    public void setConnection(ConnectionUtils connection) {
        this.connection = connection;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAll() {
        List<Account> accounts;
        try {
            String sql = "select * from account";
            accounts = runner.query(connection.getConnection(),sql, new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return accounts;
    }

    public Account findById(int id) {
        Account account;
        try {
            String sql = "select * from account where id=?";
            account = runner.query(connection.getConnection(),sql,new BeanHandler<Account>(Account.class),id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return account;
    }

    public void update(Account account) {
        try {
            String sql = "update account set name = ?,money=? where id=?";
            runner.update(connection.getConnection(),sql,account.getName(),account.getMoney(),account.getId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void insert(Account account) {
        try {
            String sql = "insert into account(name,money) values(?,?)";
            runner.update(connection.getConnection(),sql,account.getName(),account.getMoney());
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    public void delete(int id) {
        try {
            String sql = "delete from account where id=?";
            runner.update(connection.getConnection(),sql,id);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Account findAccountByName(String name){
        List<Account> accounts;
        try {
            String sql = "select * from account where name=?";
            accounts = runner.query(connection.getConnection(),sql,new BeanListHandler<Account>(Account.class),name);
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
