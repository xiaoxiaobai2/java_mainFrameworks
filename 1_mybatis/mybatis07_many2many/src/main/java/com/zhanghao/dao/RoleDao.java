package com.zhanghao.dao;

import com.zhanghao.domain.Role;

import java.util.List;

public interface RoleDao {
    /**
     * 查询所有角色对应的用户
     * @return
     */
    List<Role> findAll();
}
