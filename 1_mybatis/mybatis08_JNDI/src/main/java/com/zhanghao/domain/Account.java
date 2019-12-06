package com.zhanghao.domain;

public class Account {
    private int id;//账户id
    private int uid;//对应用户id
    private double money;

    //从表实体包含主表实体的对象引用
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account(int id, int uid, int money, User user) {
        this.id = id;
        this.uid = uid;
        this.money = money;
        this.user = user;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                "}     " ;
    }
}
