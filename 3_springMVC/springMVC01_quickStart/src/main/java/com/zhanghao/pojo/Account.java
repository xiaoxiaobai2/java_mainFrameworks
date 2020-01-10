package com.zhanghao.pojo;

import java.util.List;
import java.util.Map;

public class Account {
    private User user;
    private double money;
    private List<User> list;
    private Map<String,User> map;

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "user=" + user +
                ", money=" + money +
                ", list=" + list +
                ", map=" + map +
                '}';
    }
}
