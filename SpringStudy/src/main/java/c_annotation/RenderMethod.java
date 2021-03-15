package c_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RenderMethod {
    public enum MethodType {INQUIRE}

    public MethodType method() default MethodType.INQUIRE;

    public MyAnnotation[] parameters(); // 参数列表

}
