package c_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by S0111 on 2019/8/20.
 * 自定义注解类声明
 */
@Target(value = {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MyAnnotation {


    // 参数类型
    public enum ParameterType {STRING, SHORT, INT, BOOL, LONG, OBJECT}

    // 参数值的来源
    public enum ScopeType {NORMAL, SESSION, COOKIE, ATTRIBUTE, CUSTOM}


    String name();

    String value();

    String path() default "";
}