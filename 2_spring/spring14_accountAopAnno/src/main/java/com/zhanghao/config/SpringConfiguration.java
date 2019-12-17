package com.zhanghao.config;

import org.springframework.context.annotation.*;

//@Configuration//指定为Aop配置文件
@ComponentScan("com.zhanghao")
@Import(JdbcConfiguration.class)
@PropertySource("classpath:jdbcConfig.properties")
@EnableAspectJAutoProxy
public class SpringConfiguration {
}
