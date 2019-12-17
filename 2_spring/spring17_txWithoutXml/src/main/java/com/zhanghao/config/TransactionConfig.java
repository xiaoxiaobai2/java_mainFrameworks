package com.zhanghao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 和事务相关的类配置
 */
public class TransactionConfig {
    @Bean("transactionManger")
    public PlatformTransactionManager createTransactionManger(DataSource dataSource){
        return  new DataSourceTransactionManager(dataSource);
    }
}
