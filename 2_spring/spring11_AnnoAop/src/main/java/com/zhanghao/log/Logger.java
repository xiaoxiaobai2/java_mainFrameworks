package com.zhanghao.log;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component("logger")
//表示当前类是一个切面
@Aspect
//@EnableAspectJAutoProxy//开启自动配置代理
public class Logger {

//    配置切入点表达式
    @Pointcut("execution(* com..zhanghao.service.Impl.*.*(..))")
    private void pc1(){}


    @Before("pc1()")
    public void printBeforeLog(){
        System.out.println("打印日志！--前置");
    }

    @AfterReturning("pc1()")
    public void printAfterLog(){
        System.out.println("打印日志！--后置");
    }

    @AfterThrowing("pc1()")
    public void printExceptionLog(){
        System.out.println("打印日志！--异常");
    }


    @After("pc1()")
    public void printFinallyLog(){
        System.out.println("打印日志！--最终");
    }

}
