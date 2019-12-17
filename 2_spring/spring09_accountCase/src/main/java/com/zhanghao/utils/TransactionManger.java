package com.zhanghao.utils;

import java.sql.SQLException;

public class TransactionManger {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void openTransaction(){
        try {
            connectionUtils.getConnection().setAutoCommit(false);
//            System.out.println("?????????");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commitTransaction(){
        try {
            connectionUtils.getConnection().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollbackTransaction(){
        try {
            connectionUtils.getConnection().rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     */
    public void releaseTransaction(){
        try {
            connectionUtils.getConnection().close();
            connectionUtils.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
