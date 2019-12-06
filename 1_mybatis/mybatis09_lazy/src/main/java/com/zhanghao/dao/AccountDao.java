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
     * 通过uid查找 账户
     * @param uid
     * @return
     */
    Account findByUid(int uid);
}
