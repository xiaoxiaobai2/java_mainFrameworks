package com.zhanghao.dbassist;

import com.zhanghao.handler.ResultSetHandler;
import com.zhanghao.handler.impl.BeanHandler;

import javax.sql.DataSource;
import java.sql.*;

public class DBassist {
    private DataSource dataSource;
    public DBassist() {
    }

    public DBassist(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 执行增删改
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql,Object... args){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //获取连接对象
            connection = dataSource.getConnection();
            //获取预处理对象
            ps = connection.prepareStatement(sql);
            //获取预处理参数个数
            ParameterMetaData parameterMetaData = ps.getParameterMetaData();
            int parameterCount = parameterMetaData.getParameterCount();
            //判断个数是否一致
            if (parameterCount>0){
                if (args == null) {
                    throw new NullPointerException("没有sql语句执行必须的参数");
                }
                if (args.length != parameterCount) {
                    throw new RuntimeException("传入的参数个数和语句所需的参数个数不一致，语句无法执行");
                }
            }
            //设置参数
            for (int i = 0; i < parameterCount; i++) {
                ps.setObject(i+1,args[i]);
            }
            //执行语句,返回结果
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            close(connection,ps,null);
        }
    }

    public Object query(String sql,ResultSetHandler rsh,Object... args){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //获取连接对象
            connection = dataSource.getConnection();
            //获取预处理对象
            ps = connection.prepareStatement(sql);
            //获取预处理参数个数
            ParameterMetaData parameterMetaData = ps.getParameterMetaData();
            int parameterCount = parameterMetaData.getParameterCount();
            //判断个数是否一致
            if (parameterCount>0){
                if (args == null) {
                    throw new NullPointerException("没有sql语句执行必须的参数");
                }
                if (args.length != parameterCount) {
                    throw new RuntimeException("传入的参数个数和语句所需的参数个数不一致，语句无法执行");
                }
            }
            //设置参数
            for (int i = 0; i < parameterCount; i++) {
                ps.setObject(i+1,args[i]);
            }
            //执行语句,返回结果
            rs = ps.executeQuery();
            return rsh.handle(rs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            close(connection,ps,rs);
        }
    }



    private void close(Connection c, PreparedStatement ps, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (c!=null){
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
