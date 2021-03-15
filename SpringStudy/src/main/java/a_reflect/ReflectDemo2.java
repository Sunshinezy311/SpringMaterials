package a_reflect;

import a_reflect.entity.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectDemo2 {
    //2获取Class字节码的使用方式
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Class<Person> personClass = Person.class;
        Person p = new Person();
        //获取功能
        //1. 获取成员变量们
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            //注意getFields()是获取public修饰的成员变量的。所以当前打印的是空的
            System.out.println(field);
        }
        // 同样，getField("")也是获取public修饰的成员变量的
        Field a = personClass.getField("a");

        Object aVal = a.get(p);
        System.out.println(aVal);
        a.set(p, "a");
        System.out.println(p.a);

        //getDeclaredFields()方法获取的是所有定义的成员变量，不论什么样的修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        //私有变量是不可以访问的，会报错，必须通过setAccessible(true)，来实现暴力反射。
        Field b = p.getClass().getDeclaredField("b");
        b.setAccessible(true);
        System.out.println(b.get(p));


        //2. 获取构造方法们
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        Object person=constructor.newInstance("张三",24);
        System.out.println(person);
        //如果使用空参构造方法创建对象，可以直接用Class中的newInstance()来实现初始化
        Person person1 = personClass.newInstance();
        System.out.println(person1);

        //3. 获取成员方法们
        Method doSomething = personClass.getMethod("doSomething");
        doSomething.invoke(p);
        Method doSomething1 = personClass.getMethod("doSomething",String.class);
        doSomething1.invoke(p,"xixixi");

        System.out.println(Arrays.toString(personClass.getDeclaredMethods()));
        System.out.println(doSomething.getName());
        //4. 获取类名
        //5.

    }
}
