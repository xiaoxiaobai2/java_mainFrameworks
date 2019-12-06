package com.zhanghao.mybatis.sqlsession.impl;

import com.zhanghao.mybatis.cfg.Configuration;
import com.zhanghao.mybatis.sqlsession.SqlSession;
import com.zhanghao.mybatis.sqlsession.SqlSessionFactory;
import com.zhanghao.mybatis.utils.DataSourceUtil;

import java.sql.Connection;

public class SqlSessionFactoryImpl implements SqlSessionFactory {
    private Configuration conf;
    private Connection conn;
    public SqlSessionFactoryImpl(Configuration conf) {
        this.conf = conf;
        this.conn = DataSourceUtil.getConn(conf);
    }

    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    public SqlSession openSession() {
        return new SqlSessionImpl(conf,conn);
    }
}
