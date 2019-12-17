package com.zhanghao.handler.impl;

import com.zhanghao.handler.ResultSetHandler;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler implements ResultSetHandler {
    private Class domain;

    public BeanListHandler(Class domain) {
        this.domain = domain;
    }

    public Object handle(ResultSet rs) {
        try {
            List list = new ArrayList();
            while (rs.next()){
                //根据字节码文件创建实体类对象
                Object bean = domain.newInstance();

                //获取返回类型参数值
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    //获取列名
                    String columnName = rsmd.getColumnName(i + 1);
                    //列名其实就是实体类的属性名称，于是就可以使用列名得到实体类中属性的描述器
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnName,domain);
                    //获取值
                    Object columnValue = rs.getObject(i + 1);
                    //获取写入方法
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    //根据列名填充实体类对象
                    writeMethod.invoke(bean,columnValue);
                }
                list.add(bean);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
