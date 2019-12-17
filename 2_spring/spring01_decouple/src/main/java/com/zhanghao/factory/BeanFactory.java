package com.zhanghao.factory;


import javax.naming.NoInitialContextException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private static Map<String,Object> beanMap = new HashMap<String, Object>();
    static {
        try {
            Properties properties = new Properties();
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("javabean.properties");
            properties.load(is);
            //获取  所有的key  返回枚举类型
            Enumeration propertyNames = properties.propertyNames();
//            遍历beanName，根据全限定类名创建对象，并存储到key
            while (propertyNames.hasMoreElements()){
                //1、获取beanName
                String beanName = (String)propertyNames.nextElement();
                //2、获取全限定类名
                String property = properties.getProperty(beanName);
                //3、利用反射动态加载
                Object o = Class.forName(property).newInstance();
                //4、存储到Map中，实现单例。
                beanMap.put(beanName,o);
            }
        } catch (IOException e) {
            System.err.println("初始化资源失败！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String beanName){
        return beanMap.get(beanName);
    }
}
