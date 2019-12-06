package com.zhanghao.dao;

import com.zhanghao.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 使用注解的方式
 *
 *     当数据库 列名 和 Java 属性名不同时 用@Result 注解配置    如果为主键  设置 id=true
 *
 *
 */
@CacheNamespace(blocking = true)
public interface UserDao {
    /**
     * 查询所有   使用注解方式
     * @return
     */
    @Select("select * from tab_user")
//    当数据库 列名 和 Java 属性名不同时 用@Result 注解配置    如果为主键  设置 id=true, 并且可以著名id方便复用
    @Results(value = {@Result(id = true,column = "username" , property = "username"),
            @Result( property = "accounts" ,column = "id",many = @Many(select = "com.zhanghao.dao.AccountDao.findByUid" ,fetchType = FetchType.LAZY))},
            id = "userMap")

    List<User> findAll();

    @Select("select * from tab_user where id=#{id}")
    User findById(int id);

    /**
     * 模糊查询
     * @param username
     * @return
     */
    @Select("select * from tab_user where username like #{username}")
    List<User> findByName(String username);

    /**
     * 统计记录数
     * @return
     */
    @Select("select count(*) from tab_user")
    int findTotal();
}
