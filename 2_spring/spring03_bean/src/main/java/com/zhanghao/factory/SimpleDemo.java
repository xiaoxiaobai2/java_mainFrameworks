package com.zhanghao.factory;

/**
 * 测试工厂模式创建对象
 */
public class SimpleDemo {
    public void init(){
        System.out.println("初始化了。。。");
    }
    public SimpleDemo() {
        System.out.println("被创建了！");
    }

    public void destory(){
        System.out.println("被销毁了。。。。");
    }
}
