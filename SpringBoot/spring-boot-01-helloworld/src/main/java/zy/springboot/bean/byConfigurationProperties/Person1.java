package zy.springboot.bean.byConfigurationProperties;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

//将yaml中的内容加载到这里,
@Component
//注意不支持el表达式
//只能从全局的配置文件中读取
@ConfigurationProperties//告诉Spring Boot本类中的所有属性和配置文件中相关的配置进行绑定
        (prefix = "person")//配置中哪个下面中的所有属性进行一一映射
//只有组件是容器中的组件, 才能给容器提供ConfigurationProperties功能
@Getter
@Setter
@ToString
//ConfigurationProperties支持JSR303校验数据格式, Spring原生注解不支持
@Validated
public class Person1 {
    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;
}
