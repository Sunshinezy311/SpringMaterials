package di.constructor_di;

public class ConstructDependence1 {
    public ConstructDependence1() {
        System.out.println(ConstructDependence1.class + "已初始化");
    }

    public void run() {
        System.out.println("函数run()运行自：" + ConstructDependence1.class);
    }
}
