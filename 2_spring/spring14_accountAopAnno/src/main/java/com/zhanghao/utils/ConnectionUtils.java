package com.zhanghao.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component("connectionUtils")
public class ConnectionUtils {


    @Autowired
    private DataSource dataSource;

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();


    /**
     * 获取当前线程的连接
     * @return
     */
    public Connection getConnection(){
        try {
            //获取和当前线程绑定的连接，为空则从连接池获取新的连接并绑定。
            Connection connection = threadLocal.get();
            if (connection==null){
                //获取新的连接
                connection = dataSource.getConnection();
                //绑定
                threadLocal.set(connection);
            }
            return connection;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    /**
     * 把连接和线程解绑
     */
    public void release(){
        threadLocal.remove();
    }
}
