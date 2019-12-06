package com.zhanghao.dao;

import com.zhanghao.domain.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 通过ID查找 账户
     * @param id
     * @return
     */
    Account findById(int id);
}
