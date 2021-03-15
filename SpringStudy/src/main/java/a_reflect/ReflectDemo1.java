package a_reflect;

import a_reflect.entity.Person;

public class ReflectDemo1 {
    //1获取Class对象的方式
    //每一个Class对象中都封装了成员变量，构造器和方法
    public static void main(String[] args) throws ClassNotFoundException {
        //Class.forName(类名)，将字节码文件加载到内存（Source阶段）
        //这种方式多用于配置文件中
        Class clz = Class.forName("a_reflect.entity.Person");
        System.out.println(clz);

        //类名.class，通过类名的属性class获取（Class阶段）
        //此方式多用于参数的传递
        Class clz2 = Person.class;
        System.out.println(clz2);


        //对象.getClass(),此方法在Object中定义着（Runtime阶段）
        //多用于对象获取字节码的方式
        Person p = new Person();
        Class clz3 = p.getClass();
        System.out.println(clz3);
        //这三个对象相等嘛？
        System.out.println(clz==clz2);
        System.out.println(clz==clz3);
        System.out.println(clz2==clz3);
        //结论：同一个字节码文件，在一次程序运行的过程中，不论通过上述哪一种方式，获取的对象都是同一个
    }
}
