package com.zhanghao.bean;

import java.lang.reflect.Array;
import java.util.*;

public class TestBean3 {
    private List list;
    private Map map;
    private Set set;
    private String[] array;
    private Properties properties;

    public TestBean3() {
    }

    @Override
    public String toString() {
        return "TestBean3{" +
                "list=" + list +
                ", map=" + map +
                ", set=" + set +
                ", array=" + array +
                ", properties=" + properties +
                '}';
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
