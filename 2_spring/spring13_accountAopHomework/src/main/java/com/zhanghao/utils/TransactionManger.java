package com.zhanghao.utils;


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
            System.out.println("关闭自动提交事务。");
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
            System.out.println("提交事务。");
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
            System.out.println("回滚事务。");
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
            System.out.println("释放资源。");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
