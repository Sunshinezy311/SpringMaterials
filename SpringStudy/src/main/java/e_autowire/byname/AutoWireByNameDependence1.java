package e_autowire.byname;

public class AutoWireByNameDependence1 {
    public AutoWireByNameDependence1() {
        System.out.println(AutoWireByNameDependence1.class + "已初始化。");
    }

    public void run() {
        System.out.println("函数run()运行自：" + AutoWireByNameDependence1.class);
    }
}
