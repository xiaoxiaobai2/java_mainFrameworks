package com.zhanghao.mybatis.sqlsession;

import com.sun.org.apache.xml.internal.utils.XML11Char;
import com.zhanghao.mybatis.cfg.Configuration;
import com.zhanghao.mybatis.sqlsession.impl.SqlSessionFactoryImpl;
import com.zhanghao.mybatis.utils.XmlHelper;

import java.io.InputStream;

/**
 * 用于创建sqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactoryBuilder() {
    }

    /**
     * 根据配置参数的字节输入流创建 SqlSessionFactory 对象
     * @param is
     * @return
     */
    public SqlSessionFactory build(InputStream is){
        Configuration conf = XmlHelper.getConf(is);
        return new SqlSessionFactoryImpl(conf);
    }
}
