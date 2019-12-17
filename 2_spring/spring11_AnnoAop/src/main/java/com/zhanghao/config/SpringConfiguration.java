package com.zhanghao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.zhanghao")//指定要扫描的包
@Configuration
@EnableAspectJAutoProxy//开启自动配置代理
public class SpringConfiguration {

}
