package com.zhanghao.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义类型转换器   String to Date
 */
public class StringToDate implements Converter<String, Date> {


    @Override
    public Date convert(String source) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {
            parse = dateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
}
