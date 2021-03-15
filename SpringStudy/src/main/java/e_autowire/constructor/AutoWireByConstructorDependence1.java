package e_autowire.constructor;

public class AutoWireByConstructorDependence1 {
    public AutoWireByConstructorDependence1() {
        System.out.println(AutoWireByConstructorDependence1.class + " is initial");
    }

    public void run() {
        System.out.println("函数run()运行自：" + AutoWireByConstructorDependence1.class);
    }
}
