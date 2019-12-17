package com.zhanghao.service.Impl;

import com.zhanghao.service.Service;
import org.springframework.stereotype.Component;

@Component("service")
public class ServiceImpl implements Service {

    public void saveAccount() {
        System.out.println("保存账户");
    }

    public int findTotal() {
        System.out.println("查询总数！");
        int i = 1/0;
        return 10;
    }

    public int delete(int id) {
        System.out.println("删除用户！");
        return 0;
    }
}
