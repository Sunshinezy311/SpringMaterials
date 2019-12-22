package autowire.constructor;

public class AutoWiredByConstructorMain {
    private AutoWireByConstructorDependence1 autoWireByConstructorDependence1;
    private String name;

    public AutoWiredByConstructorMain(AutoWireByConstructorDependence1 autoWireByConstructorDependence1,
                                      String name) {
        this.autoWireByConstructorDependence1 = autoWireByConstructorDependence1;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public AutoWireByConstructorDependence1 getAutoWireByConstructorDependence1() {
        return autoWireByConstructorDependence1;
    }

    public void run() {
        System.out.println("函数run()运行自：" + AutoWiredByConstructorMain.class + "正在调用autoWireByConstructorDependence1.run()");
        autoWireByConstructorDependence1.run();
    }
}
