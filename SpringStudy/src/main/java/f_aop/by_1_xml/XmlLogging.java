package f_aop.by_1_xml;

public class XmlLogging {
    /**
     * This is the method which I would like to execute
     * before a selected method execution.
     */
    public void beforeAdvice() {
        System.out.println("在执行下面的方法前，会先执行aop:before切片里的内容");
    }

    /**
     * This is the method which I would like to execute
     * after a selected method execution.
     */
    public void afterAdvice() {
        System.out.println("在执行上面的方法后，会再执行aop:after切片里的内容");
    }

    /**
     * This is the method which I would like to execute
     * when any method returns.
     */
    public void afterReturningAdvice(Object retVal) {
        System.out.println("在上面的方法返回以后，会在aop:after-returning切片里执行后续的内容，例如这里会打印返回结果：" + retVal.toString());
    }

    /**
     * This is the method which I would like to execute
     * if there is an exception raised.
     */
    public void AfterThrowingAdvice(IllegalArgumentException ex) {
        System.out.println("当抛出异常后，会在aop:after-throwing切片里执行后续的内容，例如这里会打印异常的堆栈信息：" + ex.toString());
    }
}
