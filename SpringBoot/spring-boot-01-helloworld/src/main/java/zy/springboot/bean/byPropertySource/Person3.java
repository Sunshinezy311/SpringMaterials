package zy.springboot.bean.byPropertySource;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
//可以指定对应的文件来加载里面的内容
@PropertySource(value = {"classpath:person.properties"})
@ConfigurationProperties(prefix = "person1")
@Getter
@Setter
@ToString
public class Person3 {
    private String lastName;
    private Integer age;
    private Boolean boss;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog3 dog;
}
