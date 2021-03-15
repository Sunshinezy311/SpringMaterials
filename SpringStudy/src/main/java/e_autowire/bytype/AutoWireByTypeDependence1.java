package e_autowire.bytype;

public class AutoWireByTypeDependence1 {
    public AutoWireByTypeDependence1(){
        System.out.println(AutoWireByTypeDependence1.class+"已初始化。");
    }

    public void run(){
        System.out.println("函数run()运行自：" + AutoWireByTypeDependence1.class);
    }
}
