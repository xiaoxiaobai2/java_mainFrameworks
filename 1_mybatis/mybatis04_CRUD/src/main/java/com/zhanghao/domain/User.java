package com.zhanghao.domain;

public class User {
    private String name;
    private Integer age;
    private Integer uid;

    public User() {
    }

    public User(String name, Integer age, Integer uid) {
        this.name = name;
        this.age = age;
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", uid=" + uid +
                '}';
    }
}
