package di.setter_di;

public class SetterDiMian {
    private SetterDependence1 setterDependence1;

    public void setSetterDependence1(SetterDependence1 setterDependence1) {
        System.out.println(SetterDiMian.class + "的setter函数开始运行.");
        this.setterDependence1 = setterDependence1;
    }

    public SetterDependence1 getSetterDependence1() {
        return setterDependence1;
    }

    public void run() {
        setterDependence1.run();
    }
}
