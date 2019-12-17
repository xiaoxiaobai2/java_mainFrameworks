package com.zhanghao.ui;

import com.zhanghao.bean.TestBean;
import com.zhanghao.bean.TestBean2;
import com.zhanghao.bean.TestBean3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Client {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //测试带参构造函数参数注入
        TestBean testBean = ac.getBean("testBean", TestBean.class);
        System.out.println(testBean.toString());

//        测试无参构造函数，set  参数注入
        TestBean2 testBean2 = ac.getBean("testBean2", TestBean2.class);
        System.out.println(testBean2.toString());

        //        测试无参构造函数，set  参数注入  特殊对象，集合

        TestBean3 testBean3 = ac.getBean("testBean3", TestBean3.class);
        System.out.println(testBean3.toString());
    }
}
