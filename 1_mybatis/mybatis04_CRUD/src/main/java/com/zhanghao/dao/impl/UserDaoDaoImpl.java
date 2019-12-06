package com.zhanghao.dao.impl;

import com.zhanghao.dao.UserDaoDao;
import com.zhanghao.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoDaoImpl implements UserDaoDao {
    private SqlSessionFactory factory;

    public UserDaoDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    /**
     * 自己实现dao
     * @return
     */
    public List<User> findAll() {
        SqlSession sqlSession = factory.openSession();
        //传递 namspace+id   有参数的在后面加上参数
        List<User> users = sqlSession.selectList("com.zhanghao.dao.UserDaoDao.findAll");
        sqlSession.close();
        return users;
    }
}
