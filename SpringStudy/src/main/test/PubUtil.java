import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PubUtil {
    /**
     *
     最常被使用的 ApplicationContext 接口实现
     FileSystemXmlApplicationContext：该容器从 XML 文件中加载已被定义的 bean。
                                      在这里，你需要提供给构造器 XML 文件的完整路径。
     ClassPathXmlApplicationContext：该容器从 XML 文件中加载已被定义的 bean。
                                     在这里，你不需要提供 XML 文件的完整路径，只需正确配置 CLASSPATH 环境变量即可，
                                     因为，容器会从 CLASSPATH 中搜索 bean 配置文件。
     WebXmlApplicationContext：该容器会在一个 web 应用程序的范围内加载在 XML 文件中已被定义的 bean。

     */
    private ClassPathXmlApplicationContext context;
    PubUtil(String xmlPath) {
        try {
            context = new ClassPathXmlApplicationContext(xmlPath.split("[,\\s]+"));
            context.start();
            System.out.println("xml文件读取成功");
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        context.destroy();
    }


    @SuppressWarnings("unchecked")
    <T> T getBean(String beanId) {
        try {
            return (T) context.getBean(beanId);
        } catch (BeansException e) {
            e.printStackTrace();
            return null;
        }
    }

    protected <T extends Object> T getBean(Class<T> clazz) {
        try {
            return context.getBean(clazz);
        } catch (BeansException e) {
            e.printStackTrace();
            return null;
        }
    }

}
