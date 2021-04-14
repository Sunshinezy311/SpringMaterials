<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <title>Title</title>
        <script src="js/jquery.min.js"></script>
    </head>

    <body>
        <h3>入门程序</h3>
        <div>
            <h5>异常处理，异常处理器需要实现HandlerExceptionResolver接口，请求出现异常后，根据处理方法抛出的异常，抛到自己定义的异常中。
                注意，所有请求抛出的异常都是进入到这个方法中，所以要特别留意一下此处的异常分类和处理</h5>
            <a href="exception/testException">异常处理</a>
        </div>

        <div>
            <h5>拦截器和过滤器</h5>
            <a href="interceptor/testInterceptor">实现拦截器</a>
        </div>
    </body>

    </html>