package c_annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyAnnotationImplement {
    public static void run() throws ClassNotFoundException, NoSuchFieldException {
        Class<?> clazz = Class.forName("c_annotation.AClass");
        MyAnnotation classAnnotation = clazz.getAnnotation(MyAnnotation.class);

        if (clazz.isAnnotationPresent(MyAnnotation.class)) {
            System.out.println("此处为获取的被注解的类信息: " + classAnnotation);
            System.out.println(classAnnotation.name() + "----" + classAnnotation.value() + "--------" + classAnnotation.path());
        }

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            MyAnnotation functionAnnotation = method.getAnnotation(MyAnnotation.class);
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                System.out.println("此处为获取的被注解的方法的信息: " + functionAnnotation);
                System.out.println("遍历:当前方法名为：" + method.getName() + "，注解信息：---" +
                        functionAnnotation.name() + "----" +
                        functionAnnotation.value() + "--------" +
                        functionAnnotation.path());
            }
        }

        //获取属性注解信息
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            MyAnnotation fieldAnnotation = field.getAnnotation(MyAnnotation.class);
            if (field.isAnnotationPresent(MyAnnotation.class)) {
                System.out.println("此处为获取的被注解的属性的信息: " + classAnnotation);
                System.out.println("遍历:当前属性名为：" + field.getName() + "，注解信息：---" +
                        fieldAnnotation.name() + "---" +
                        fieldAnnotation.value() + "---" +
                        fieldAnnotation.path());
            }
        }
    }
}
