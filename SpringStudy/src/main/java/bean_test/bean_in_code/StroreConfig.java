package bean_test.bean_in_code;

import bean_test.bean_load_resfiles.MyDriverManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:spring-context.xml")
public class StroreConfig {

    @Value("${url}")
    private String url;
    //注意该username会获取到当前操作系统用户名，因此需要起一些专有的名字以防止混淆
    @Value("${jdbc.username}")
    private String userName;
    @Value("${password}")
    private String password;

    @Bean
    public MyDriverManager myDriverManager() {
        return new MyDriverManager(url, userName, password);
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public Store getStringStore() {
        return new StringStrore();
    }
}
