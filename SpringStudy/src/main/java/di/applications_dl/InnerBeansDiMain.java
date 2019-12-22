package di.applications_dl;

public class InnerBeansDiMain {
    private InnerBeansDependence1 innerBeansDependence1;

    public void setInnerBeansDependence1(InnerBeansDependence1 innerBeansDependence1) {
        System.out.println(InnerBeansDiMain.class + "已初始化");
        this.innerBeansDependence1 = innerBeansDependence1;
    }

    public InnerBeansDependence1 getInnerBeansDependence1() {
        return innerBeansDependence1;
    }

    public void run() {
        innerBeansDependence1.run();
    }
}
