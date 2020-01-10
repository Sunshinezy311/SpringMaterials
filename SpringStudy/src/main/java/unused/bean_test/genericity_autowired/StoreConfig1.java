package unused.bean_test.genericity_autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ImportResource("classpath:spring-context.xml")
public class StoreConfig1 {

    @Autowired
    private Store1<String> s1;
    @Autowired
    private Store1<Integer> s2;


    @Bean
    public StringStore1 stringStore() {
        return new StringStore1();
    }

    @Bean
    public IntegerStore1 integerStore() {
        return new IntegerStore1();
    }

    @Bean(name = "stringStoreTest1")
    public Store1 stringStoreTest1(){
        System.out.println("s1: "+s1.getClass().getName());
        System.out.println("s2: "+s2.getClass().getName());
        return new StringStore1();
    }
}
