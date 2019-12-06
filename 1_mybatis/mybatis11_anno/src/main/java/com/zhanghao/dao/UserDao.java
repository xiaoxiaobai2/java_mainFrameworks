package com.zhanghao.dao;

import com.zhanghao.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 使用注解的方式
 *    Select   Insert  Delete Update
 *
 */
public interface UserDao {
    /**
     * 查询所有   使用注解方式
     * @return
     */
    @Select("select * from tab_user")
    List<User> findAll();

    /**
     * 根据id删除数据
     * @param id
     */
    @Delete("delete from tab_user where id=#{id}")
    void deleteById(int id);

    /**
     * 插入一条新的记录
     * @param user
     */
    @Insert("insert into tab_user(username,address,birthday,sex) values(#{username},#{address},#{birthday},#{sex})")
    void insert(User user);

    /**
     * 按ID更新一条数据
     * @param user
     */
    @Update("update tab_user set username=#{username},address=#{address},sex=#{sex},birthday=#{birthday} where id=#{id}")
    void update(User user);

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
