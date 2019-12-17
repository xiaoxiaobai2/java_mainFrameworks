package com.zhanghao.dao.impl;

import com.zhanghao.dao.AccountDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

//持久层注解
@Repository("accountDao")
/**
 * 用于指定作用范围
 */
@Scope("prototype")
public class AccountDaoImpl implements AccountDao {

    public void saveAccount() {
        System.out.println("成功保存账户。。");
    }
}
