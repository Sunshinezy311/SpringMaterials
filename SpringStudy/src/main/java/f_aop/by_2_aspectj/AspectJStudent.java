package f_aop.by_2_aspectj;

public class AspectJStudent {
    private Integer age;
    private String name;

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        System.out.println("调用getAge函数，获得年龄 : " + age);
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        System.out.println("调用getName函数，获得姓名 : " + name);
        return name;
    }

    public void printThrowException() {
        System.out.println("调用printThrowException函数，抛出异常：");
        throw new IllegalArgumentException();
    }
}
