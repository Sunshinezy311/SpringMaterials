package autowire.byname;

public class AutoWireByNameMain {
    private AutoWireByNameDependence1 autoWireByNameDependence1;
    private String name;

    public void setAutoWireByNameDependence1(AutoWireByNameDependence1 autoWireByNameDependence1) {
        this.autoWireByNameDependence1 = autoWireByNameDependence1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AutoWireByNameDependence1 getAutoWireByNameDependence1() {
        return autoWireByNameDependence1;
    }

    public String getName() {
        return name;
    }

    public void run() {
        System.out.println("函数run()运行自：" + AutoWireByNameMain.class + "正在调用autoWireByNameDependence1.run()");
        autoWireByNameDependence1.run();
    }
}
