package autowire.bytype;

public class AutoWireByTypeMain {

    private AutoWireByTypeDependence1 autoWireByTypeDependence1;
    private String name;

    public AutoWireByTypeDependence1 getAutoWireByTypeDependence1() {
        return autoWireByTypeDependence1;
    }

    public String getName() {
        return name;
    }

    public void setAutoWireByTypeDependence1(AutoWireByTypeDependence1 autoWireByTypeDependence1) {
        this.autoWireByTypeDependence1 = autoWireByTypeDependence1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println("函数run()运行自：" + AutoWireByTypeMain.class + "正在调用autoWireByTypeDependence1.run()");
        autoWireByTypeDependence1.run();
    }

}
