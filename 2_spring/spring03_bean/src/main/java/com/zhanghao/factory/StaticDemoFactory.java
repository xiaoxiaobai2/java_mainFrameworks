package com.zhanghao.factory;

/**
 * 测试单例模式
 */
public class StaticDemoFactory {

    private static StaticDemoFactory staticDemoFactory = new StaticDemoFactory();
    private StaticDemoFactory() {
    }

    public static StaticDemoFactory getInstance(){
        return staticDemoFactory;
    }
}
