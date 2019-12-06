package com.zhanghao.mybatis.sqlsession.impl;

import com.zhanghao.dao.UserDao;
import com.zhanghao.mybatis.cfg.Configuration;
import com.zhanghao.mybatis.sqlsession.SqlSession;
import com.zhanghao.proxy.MapperProxy;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class SqlSessionImpl implements SqlSession {
    private Configuration conf;
    private Connection conn;

    public SqlSessionImpl(Configuration conf,Connection conn) {
        this.conf = conf;
        this.conn = conn;
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        T proxyInstance = (T)Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(), new Class[]{daoInterfaceClass}, new MapperProxy(conf.getMappers(),conn));
        return proxyInstance;
    }

    /**
     * 用于释放资源
     */
    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("关闭数据库连接失败");
        }
    }
}
