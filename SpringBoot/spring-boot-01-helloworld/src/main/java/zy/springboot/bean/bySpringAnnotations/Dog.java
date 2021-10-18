package zy.springboot.bean.bySpringAnnotations;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Dog {
    private String name;
    private Integer age;
}
