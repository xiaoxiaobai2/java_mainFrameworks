package com.zhanghao.dao.impl;

import com.zhanghao.dao.AccountDao;
import com.zhanghao.dbassist.DBassist;
import com.zhanghao.domain.Account;
import com.zhanghao.handler.ResultSetHandler;
import com.zhanghao.handler.impl.BeanHandler;
import com.zhanghao.handler.impl.BeanListHandler;
import com.zhanghao.utils.C3P0Util;

import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private DBassist dBassist = new DBassist(C3P0Util.getDataSource());
    public List<Account> findAll() {
        ResultSetHandler rsh = new BeanListHandler(Account.class);
        String sql = "select * from account";
        List<Account> accounts = (List<Account>) dBassist.query(sql, rsh);
        return accounts;
    }

    public Account findById(int id) {
        ResultSetHandler rsh = new BeanHandler(Account.class);
        String sql = "select * from account where id=?";
        Account account = (Account) dBassist.query(sql, rsh, id);
        return account;
    }

    public void update(Account account) {
        String sql = "update account set name = ?,money=? where id=?";
        dBassist.update(sql,account.getName(),account.getMoney(),account.getId());

    }

    public void insert(Account account) {
        String sql = "insert into account(name,money) values(?,?)";
        dBassist.update(sql,account.getName(),account.getMoney());
    }

    public void delete(int id) {
        String sql = "delete from account where id=?";
        dBassist.update(sql,id);
    }
}
