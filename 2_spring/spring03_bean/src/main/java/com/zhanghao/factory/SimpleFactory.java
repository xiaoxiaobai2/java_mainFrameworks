package com.zhanghao.factory;

public class SimpleFactory {

    public SimpleDemo getSimpleDemo(){
        System.out.println("...");
        return new SimpleDemo();
    }
}
