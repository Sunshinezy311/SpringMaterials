package zy.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zy.springboot.bean.byConfigurationProperties.Person1;
import zy.springboot.bean.byPropertySource.Person3;
import zy.springboot.bean.bySpringAnnotations.Person2;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldMainApplicationTest {
    @Autowired
    Person1 person1;

    @Autowired
    Person2 person2;

    @Autowired
    Person3 person3;

    @Test
    public void test_yaml_loads() {
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
    }
}