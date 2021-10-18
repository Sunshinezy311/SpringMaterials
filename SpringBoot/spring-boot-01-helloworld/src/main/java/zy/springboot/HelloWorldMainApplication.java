package zy.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//标记是一个主程序
/*
*
注解里面有以下注解:
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration        标记了就是配置类,底层是@Configuration,Spring上使用的注解, spring-boot-autoconfigure-2.3.4.RELEASE.jar 完成j2ee的整体整合解决方案, 和自动配置
@EnableAutoConfiguration        启用自动配置功能,以前需要配置的东西,Spring Boot
* 其配置的根源,是一个pring-boot-autoconfigure-2.3.4.RELEASE.jar!\META-INF\spring.factories的文件作为输入的源头,进行遍历扫描里面的自动配置类
    @AutoConfigurationPackage
    @Import({AutoConfigurationImportSelector.class}) 给容器中导入一个组件, 导入的组件由AutoConfigurationImportSelector决定,
    ***其作用就是将主配置类(@SpringBootApplication标记的类)的所在包及下面所有子包里面的所有组件都扫面到Spring容器中***
        AutoConfigurationImportSelector  导入组件的选择器,将所有需要导入的组件全部以全类名的方式返回;这些组件就会被添加到容器中
        如下, 自动配置类有很多:
        0 = "org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration"
        1 = "org.springframework.boot.autoconfigure.aop.AopAutoConfiguration"
        2 = "org.springframework.boot.autoconfigure.amqp.RabbitAutoConfiguration"
        3 = "org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration"
        4 = "org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration"
        5 = "org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration"
        6 = "org.springframework.boot.autoconfigure.context.ConfigurationPropertiesAutoConfiguration"
        7 = "org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration"
        ......
    public @interface EnableAutoConfiguration {
*
@ComponentScan(
    excludeFilters = {@Filter(
    type = FilterType.CUSTOM,
    classes = {TypeExcludeFilter.class}
), @Filter(
    type = FilterType.CUSTOM,
    classes = {AutoConfigurationExcludeFilter.class}
)}
)
public @interface SpringBootApplication {
* */
@SpringBootApplication
/*
* resources文件夹目录结构
resources
static  保存所有的静态资源, 如: 图片, js , css
templates  保存所有的模板页面, Spring Boot默认jar包使用嵌入式的Tomcat, 不支持jsp页面; 可以使用模板引擎( freemarker\ thymeleaf)
application.yaml Spring Boot应用的配置文件
*
* */
@EnableConfigurationProperties(HttpEncodingAutoConfiguration.class)
public class HelloWorldMainApplication {
    public static void main(String[] args) {
        //启动Spring应用
        SpringApplication.run(HelloWorldMainApplication.class, args);
    }
}
