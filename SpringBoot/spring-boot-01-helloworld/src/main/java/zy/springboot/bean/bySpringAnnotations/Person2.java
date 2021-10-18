package zy.springboot.bean.bySpringAnnotations;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

//将yaml中的内容加载到这里,
@Component
//只有组件是容器中的组件, 才能给容器提供ConfigurationProperties功能
@Getter
@Setter
@ToString
public class Person2 {
    //可以使用Spring的注解实现
    //-表示的是后面字母大写.注意原生的不支持松散语法
    @Value("${person1.lastName}")
    private String name;
    //原生注解支持el表达式,ConfigurationProperties不支持
    @Value("#{11*2}")
    private Integer age;
    @Value("${person1.boss}")
    private Boolean boss;
    private Date birth;
    //Spring原生注解不支持复杂类型封装
//    @Value("${person.maps}")
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;
}
