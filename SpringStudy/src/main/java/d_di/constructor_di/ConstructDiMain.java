package d_di.constructor_di;

public class ConstructDiMain {
    private ConstructDependence1 constructDependence1;
    private ConstructDependence2 constructDependence2;

    public ConstructDiMain(ConstructDependence1 constructDependence1, ConstructDependence2 constructDependence2) {
        this.constructDependence1 = constructDependence1;
        this.constructDependence2 = constructDependence2;
        System.out.println(ConstructDiMain.class + "已初始化.");
    }

    public void run() {
        constructDependence1.run();
    }

    public void run1() {
        constructDependence2.run();
    }
}
