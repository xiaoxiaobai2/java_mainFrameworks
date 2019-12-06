package com.zhanghao.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器加载配置文件
 */
public class Resources {
    public static InputStream getResourceAsStream(String path){
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }
}
