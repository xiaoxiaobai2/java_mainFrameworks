package com.zhanghao.mybatis.sqlsession;

/**
 * 自定义Mybatis 中和数据库交互的核心类
 *      可以创建dao接口的代理对象
 */
public interface SqlSession {
    <T> T getMapper(Class<T> daoInterfaceClass);
    void close();
}
