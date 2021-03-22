package zy.springmvc.utils;


import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//将字符串转换为日期
public class String2DateConvertor implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if (s.length() == 0) {
            throw new RuntimeException("输入的字符串为空！");
        }
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        try {
            return df.parse(s);
        } catch (ParseException e) {
            throw new RuntimeException("日期转换失败！");
        }
    }
}
