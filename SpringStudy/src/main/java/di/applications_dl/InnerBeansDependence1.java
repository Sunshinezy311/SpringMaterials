package di.applications_dl;

public class InnerBeansDependence1 {
    public InnerBeansDependence1() {
        System.out.println(InnerBeansDependence1.class + "已初始化");
    }

    public void run() {
        System.out.println("函数run()运行自：" + InnerBeansDependence1.class);
    }
}
