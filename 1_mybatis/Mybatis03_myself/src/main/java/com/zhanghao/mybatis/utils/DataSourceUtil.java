package com.zhanghao.mybatis.utils;

import com.zhanghao.mybatis.cfg.Configuration;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSourceUtil {
    private Configuration conf;
    public static Connection getConn(Configuration conf){
        Connection connection = null;
        try {
            Class.forName(conf.getDriver());
            connection = DriverManager.getConnection(conf.getUrl(), conf.getUsername(), conf.getPassword());
        } catch (ClassNotFoundException e) {
            System.err.println("没有找到数据库配置文件！");
        } catch (SQLException e) {
            System.err.println("建立连接失败！");
        }
        return connection;
    }
}
