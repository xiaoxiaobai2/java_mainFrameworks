package com.zhanghao.bean;

import java.util.Date;

public class TestBean {
    private String name;
    private int age;
    private Date birthday;

    public TestBean(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "TestBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
