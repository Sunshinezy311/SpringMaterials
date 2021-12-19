package zy.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//模板引擎Thymeleaf
public class HelloWorldMainApplication {
    public static void main(String[] args) {
        //启动Spring应用
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}
