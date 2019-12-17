package com.zhanghao.utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("transactionManger")
@Aspect//配置切面
public class TransactionManger {

    @Autowired
    private ConnectionUtils connectionUtils;

    //配置切入点
    @Pointcut("execution(* com.zhanghao.service.impl.AccountServiceImpl.*(..))")
    private void pc1(){}

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


    @Around("pc1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try {
            //获取参数
            Object[] args = pjp.getArgs();
            //开启事务
            openTransaction();
            //执行事务
            rtValue = pjp.proceed(args);
            //提交事务
            commitTransaction();
        } catch (Throwable throwable) {
            //回滚事务
            rollbackTransaction();
            throwable.printStackTrace();
        } finally {
            //释放资源
            releaseTransaction();
        }

        return rtValue;

    }
}
