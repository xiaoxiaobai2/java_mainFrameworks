package com.zhanghao.ui;

import com.zhanghao.factory.SimpleDemo;
import com.zhanghao.factory.StaticDemoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class client {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");

        /*
        第一种
         */
//        SimpleDemo simpleDemo1 = ac.getBean("simpleDemo", SimpleDemo.class);
//        SimpleDemo simpleDemo2 = ac.getBean("simpleDemo", SimpleDemo.class);
//        System.out.println("simpleDemo1 = " + simpleDemo1);
//        System.out.println("simpleDemo2 = " + simpleDemo2);

        /*
        第二种
         */
//        SimpleDemo simpleDemo = ac.getBean("simpleDemo", SimpleDemo.class);

        /*
        第三种
         */
//        StaticDemoFactory staticDemo = (StaticDemoFactory) ac.getBean("staticDemo");

        /*
            测试单例生命周期，
         */
        SimpleDemo simpleDemo = ac.getBean("simpleDemo", SimpleDemo.class);
        ac.close();
    }
}
