package cn.itcast.travel.dao;


import cn.itcast.travel.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Repository("userDao")
public interface UserDao {

    @Select("select * from tab_user where username =#{username}")
    User findByUsername(String username);

    @Insert("insert into tab_user" +
            "(username,password,name,birthday,sex,telephone,email,status,code) " +
            "values(#{username},#{password},#{name},#{birthday},#{sex},#{telephone},#{email},#{status},#{code})")
    void insertUser(User user);

    @Select("select * from tab_user where code=#{arg0}")
    User findByCode(String code);

    /**
     * 更新状态码
     * @param user
     */
    @Select("update tab_user set status=#{status} where uid=#{uid}")
    void updateUserStatus(User user);

    @Select("select * from tab_user where username=#{arg0} and password=#{arg1}")
    User findUserByUsernameAndPassword(String username, String password);

    @Select("select * from tab_user")
    List<User> findAllUser();
}
