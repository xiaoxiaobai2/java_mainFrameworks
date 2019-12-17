package com.zhanghao.ui;

import com.zhanghao.factory.BeanFactory;
import com.zhanghao.service.UserService;
import com.zhanghao.service.impl.UserServiceImpl;

/**
 * 测试解耦    之前用new创建对象，每个类之间存在很大的耦合，不利于文件修改
 *      利用工厂模式，创建，实现解耦
 *          并且运用单例模式，减少内存开销
 */
public class Client {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
        UserService userService = (UserService) BeanFactory.getBean("userService");

        for (int i=0;i<5;i++) {
            userService.saveUser();
        }
    }
}
