package com.zhanghao.mybatis.utils;

import com.zhanghao.mybatis.annotation.Select;
import com.zhanghao.mybatis.cfg.Configuration;
import com.zhanghao.mybatis.cfg.Mapper;
import com.zhanghao.mybatis.io.Resources;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.rmi.MarshalledObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlHelper {
    /**
     * 获取配置信息，封装到configuration对象
     * @param conf
     * @return
     */
    public static Configuration getConf(InputStream conf){
        Configuration cfg = null;
        try {
            //封装连接信息的对象
            cfg = new Configuration();

            //1、获取SAXReader对象
            SAXReader reader = new SAXReader();
            //2、根据字节输入流获取Document对象
            Document document = reader.read(conf);
            //3、获取根节点
            Element root= document.getRootElement();
            //4、使用xpath中选择指定节点的方式，获取所有property节点
            List<Element> propertyElements = root.selectNodes("//property");
            //5、遍历节点
            for (Element propertyElement : propertyElements) {
                String name = propertyElement.attributeValue("name");
                if (name.equals("driver")){
                    String value = propertyElement.attributeValue("value");
                    cfg.setDriver(value);
                }else if (name.equals("url")){
                    String value = propertyElement.attributeValue("value");
                    cfg.setUrl(value);
                }else if (name.equals("username")){
                    String value = propertyElement.attributeValue("value");
                    cfg.setUsername(value);
                }else if (name.equals("password")){
                    String value = propertyElement.attributeValue("value");
                    cfg.setPassword(value);
                }
            }
            System.out.println(cfg.toString());
            // 使用xpath中选择指定节点的方式，获取所有property节点
            List<Element> mapperElements = root.selectNodes("//mappers/mapper");
            for (Element mapperElement : mapperElements) {
                Attribute resource = mapperElement.attribute("resource");
                if (resource!=null){
                    System.out.println("使用的是xml");
                    String mapperPath = resource.getValue();
                    System.out.println(mapperPath);
                    Map<String, Mapper> mappers = loadMapperConfig(mapperPath);
                    cfg.setMappers(mappers);
                }else {
                    System.out.println("使用的是注解的方式");
                    Attribute attribute = mapperElement.attribute("class");
                    //获取全类名
                    String classPath = attribute.getValue();
                    Map<String, Mapper> mappers = loadMapperAnnotation(classPath);
                    cfg.setMappers(mappers);
                }
            }
            System.out.println(cfg.toString());
            return cfg;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return cfg;
    }

    /**
     * 获取mapper对象，并封装到mapper  （sql语句 和 结果对象）
     * @param mapperPath
     * @return
     */
    private static Map<String,Mapper> loadMapperConfig(String mapperPath){
        System.err.println("XmlHelper.loadMapperConfig");
        HashMap<String, Mapper> mappers = null;
        try {
            mappers = new HashMap<String, Mapper>();
            InputStream is= Resources.getResourceAsStream(mapperPath);

            //1、获取SAXReader对象
            SAXReader reader = new SAXReader();
            //2、根据字节输入流获取Document对象
            Document document = reader.read(is);
            //3、获取根节点
            Element root= document.getRootElement();
            // key的一部分
            String namespace = root.attributeValue("namespace");
            System.out.println("namespace = " + namespace);
            List<Element> selectElements = root.selectNodes("//select");
            for (Element selectElement : selectElements) {
                //key的部分
                String id = selectElement.attributeValue("id");
                //value的部分
                String resultType = selectElement.attributeValue("resultType");

                //value的部分
                String querySql = selectElement.getTextTrim();
                System.out.println(querySql);
                //封装到mapper中
                Mapper mapper = new Mapper();
                mapper.setQuerySql(querySql);
                mapper.setResultType(resultType);
                
                //放到map中
                mappers.put(namespace+"."+id,mapper);
            }
            return mappers;

        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return mappers;
    }

    private static Map<String, Mapper> loadMapperAnnotation(String classPath){
        Map<String,Mapper> mappers = new HashMap<String, Mapper>();
        System.out.println("classPath = " + classPath);
        try {
            Class daoClass = Class.forName(classPath);
            Method[] methods = daoClass.getMethods();
            for (Method method : methods) {
                Mapper mapper = new Mapper();
                //先判断是否含有 Select注解
                boolean annotationPresent = method.isAnnotationPresent(Select.class);
                if (annotationPresent) {
                    Select annotation = method.getAnnotation(Select.class);
                    //找到 注解的值  sql语句
                    String querySql = annotation.value();
                    mapper.setQuerySql(querySql);
                    //找返回类型
                    Type type = method.getGenericReturnType();
                    if (type instanceof ParameterizedType){
                        ParameterizedType parameterizedType = (ParameterizedType) type;
                        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                        Class domainClass = (Class) actualTypeArguments[0];
                        String resultType = domainClass.getName();
                        mapper.setResultType(resultType);
                    }
                    //获取方法名
                    String methodName = method.getName();
                    System.out.println("methodName = " + methodName);
                    //获取全类名
                    String className = method.getDeclaringClass().getName();
                    System.out.println("className = " + className);
                    //放到 map里
                    mappers.put(className+"." +methodName,mapper);
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("加载Dao字节码文件失败！");
        }
        return mappers;
    }
}
