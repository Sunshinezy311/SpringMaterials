package di.constructor_di;

public class ConstructDependence2 {
    public ConstructDependence2() {
        System.out.println(ConstructDependence2.class + "已初始化");
    }

    public void run() {
        System.out.println("函数run()运行自：" + ConstructDependence2.class);
    }
}
