package com.zhanghao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;


/**
 * spring 配置类
 */
@Configuration
@ComponentScan("com.zhanghao")
@Import({TransactionConfig.class, JdbcConfig.class})
@PropertySource("jdbcConfig.properties")
@EnableTransactionManagement//开启事务支持
public class SpringConfiguration {
}
