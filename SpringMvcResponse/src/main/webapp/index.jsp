<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <title>Title</title>
    </head>

    <body>

        <h3>入门程序</h3>
        <div>
            <p>当返回值为String类型的时候，在request的处理方法中将结果放入Model中，可以在jsp文件中使用EL表达式中取出结果</p>
            <a href="user/testString">测试返回String</a>
        </div>

        <div>
            <p>对于没有返回值的情况，默认情况下不设置任何值，会访问testVoid.jsp文件，即提交请求作为路径，如果不存在则报404错误</p>
            <a href="user/testVoidByForward">测试testVoidByForward，跳转到另一个页面</a><br>
            <a href="user/testVoid1ByRedirect">测试testVoid1ByRedirect,直接返回页面自己</a><br>
            <a href="user/testVoid1ByDirect">测试testVoid1ByDirect，直接在代码中注入一个新的页面</a><br>
        </div>

    </body>

    </html>