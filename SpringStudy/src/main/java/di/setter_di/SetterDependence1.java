package di.setter_di;

public class SetterDependence1 {
    public SetterDependence1() {
        System.out.println(SetterDependence1.class + "已初始化");
    }

    public void run() {
        System.out.println("函数run()运行自：" + SetterDependence1.class);
    }
}
