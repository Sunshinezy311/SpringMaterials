package bean_test.genericity_autowired;

//注意泛型的接口实现
public class StringStore1 implements Store1<String> {
    public void init(){
        System.out.println("This is init");
    }

    public void destroy(){
        System.out.println("This is destroy");
    }
}
