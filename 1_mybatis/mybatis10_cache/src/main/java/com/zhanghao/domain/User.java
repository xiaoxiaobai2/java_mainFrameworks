package com.zhanghao.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class User implements Serializable {
    private String username;
    private Date birthday;
    private String sex;
    private String address;
    private Integer id;
    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User(String username, Date birthday, String sex, String address, Integer id) {
        this.username = username;
        this.birthday = birthday;
        this.sex = sex;
        this.address = address;
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                "}" ;
    }
}
