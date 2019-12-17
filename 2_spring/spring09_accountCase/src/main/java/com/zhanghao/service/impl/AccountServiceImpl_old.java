//package com.zhanghao.service.impl;
//
//import com.zhanghao.dao.AccountDao;
//import com.zhanghao.domain.Account;
//import com.zhanghao.service.AccountService;
//import com.zhanghao.utils.TransactionManger;
//
//import java.util.List;
//
//public class AccountServiceImpl_old implements AccountService {
//
//    private AccountDao accountDao;
//    private TransactionManger manger;
//
//    public void setManger(TransactionManger manger) {
//        this.manger = manger;
//    }
//
//    public void setAccountDao(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }
//
//    public void saveAccount(Account account) {
//        try {
//            //1、开启事务
//            manger.openTransaction();
//            //2、执行操作
//            accountDao.insert(account);
//            //3、提交事务
//            manger.commitTransaction();
//        } catch (Exception e) {
//            //4、回滚操作
//            manger.rollbackTransaction();
//            throw new RuntimeException();
//        } finally {
//            //5、释放资源
//            manger.releaseTransaction();
//        }
//    }
//
//    public List<Account> findAllAccount() {
//        try {
//            //1、开启事务
//            manger.openTransaction();
//            //2、执行操作
//            List<Account> accounts = accountDao.findAll();
//            //3、提交事务
//            manger.commitTransaction();
//            return accounts;
//        } catch (Exception e) {
//            //4、回滚操作
//            manger.rollbackTransaction();
//            throw new RuntimeException();
//        } finally {
//            //5、释放资源
//            manger.releaseTransaction();
//        }
//    }
//
//    public Account findAccountById(int id) {
//        try {
//            //1、开启事务
//            manger.openTransaction();
//            //2、执行操作
//            Account account = accountDao.findById(id);
//            //3、提交事务
//            manger.commitTransaction();
//            return account;
//        } catch (Exception e) {
//            //4、回滚操作
//            manger.rollbackTransaction();
//            throw new RuntimeException();
//        } finally {
//            //5、释放资源
//            manger.releaseTransaction();
//        }
//    }
//
//    public void deleteAccount(int id) {
//        try {
//            //1、开启事务
//            manger.openTransaction();
//            //2、执行操作
//            accountDao.delete(id);
//            //3、提交事务
//            manger.commitTransaction();
//        } catch (Exception e) {
//            //4、回滚操作
//            manger.rollbackTransaction();
//            throw new RuntimeException();
//        } finally {
//            //5、释放资源
//            manger.releaseTransaction();
//        }
//    }
//
//    public void updateAccount(Account account) {
//        try {
//            //1、开启事务
//            manger.openTransaction();
//            //2、执行操作
//            accountDao.update(account);
//            //3、提交事务
//            manger.commitTransaction();
//        } catch (Exception e) {
//            //4、回滚操作
//            manger.rollbackTransaction();
//            throw new RuntimeException();
//        } finally {
//            //5、释放资源
//            manger.releaseTransaction();
//        }
//    }
//
//    public Account findAccountByName(String name){
//        try {
//            //1、开启事务
//            manger.openTransaction();
//            //2、执行操作
//            Account accountByName = accountDao.findAccountByName(name);
//            //3、提交事务
//            manger.commitTransaction();
//            return accountByName;
//        } catch (Exception e) {
//            //4、回滚操作
//            manger.rollbackTransaction();
//            throw new RuntimeException();
//        } finally {
//            //5、释放资源
//            manger.releaseTransaction();
//        }
//    }
//
//    public void transaction(String sourceName,String targetName,float money){
//        try {
//            //1、开启事务
//            manger.openTransaction();
//            //2、执行操作
//
//            //        查找源账户
//            Account sourceAccount = accountDao.findAccountByName(sourceName);
////        查找目标账户
//            Account targetAccount = accountDao.findAccountByName(targetName);
////        修改原账户金额
//            sourceAccount.setMoney(sourceAccount.getMoney()-money);
//            accountDao.update(sourceAccount);
//
////            int i=1/0;
//
////        修改目标账户金额
//            targetAccount.setMoney(targetAccount.getMoney()+money);
//            accountDao.update(targetAccount);
//
//            //3、提交事务
//            manger.commitTransaction();
//        } catch (Exception e) {
//            //4、回滚操作
//            manger.rollbackTransaction();
//            throw new RuntimeException();
//        } finally {
//            //5、释放资源
//            manger.releaseTransaction();
//        }
//
//    }
//}
