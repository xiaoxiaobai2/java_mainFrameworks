package com.zhanghao.factory;

import com.zhanghao.dao.AccountDao;
import com.zhanghao.dao.impl.AccountDaoImpl;
import com.zhanghao.service.AccountService;
import com.zhanghao.service.impl.AccountServiceImpl;
import com.zhanghao.utils.TransactionManger;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {
    private TransactionManger manger;
    private AccountService accountService;

    public final void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }


    public void setManger(TransactionManger manger) {
        this.manger = manger;
    }

    /**
     * 获取代理对象
     * @return 返回代理对象
     */
    public AccountService getAccountService(){
        return (AccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object returnValue = null;
                try {
                    //1、开启事务
                    manger.openTransaction();
                    //2、执行操作
                    returnValue = method.invoke(accountService, args);
                    //3、提交事务
                    manger.commitTransaction();
                } catch (Exception e) {
                    //4、回滚操作
                    manger.rollbackTransaction();
                    throw new RuntimeException();
                } finally {
                    //5、释放资源
                    manger.releaseTransaction();
                }
                return returnValue;
            }
        });
    }
}
