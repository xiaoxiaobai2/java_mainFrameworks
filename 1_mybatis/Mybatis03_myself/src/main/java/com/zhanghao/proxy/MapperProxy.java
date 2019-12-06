package com.zhanghao.proxy;

import com.zhanghao.mybatis.cfg.Mapper;
import com.zhanghao.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

public class MapperProxy implements InvocationHandler {
    private Connection conn;
    private Map<String,Mapper> mappers;

    public MapperProxy(Map<String, Mapper> mappers,Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.err.println("MapperProxy.invoke");
        String className = method.getDeclaringClass().getName();
        System.out.println("className = " + className);
        String methodName = method.getName();
        System.out.println("methodName = " + methodName);
        String key = className + "." +methodName;
        Mapper mapper = mappers.get(key);
        String sql ="";
        if (mapper!=null){
            sql = mapper.getQuerySql();
        }else {
            return new RuntimeException("无对应的mapper");
        }
        return new Executor().selectList(mapper,conn,args);
    }
}
