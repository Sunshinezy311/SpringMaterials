<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <title>Title</title>
    </head>

    <body>
        <h3>入门程序</h3>
        <div>
            <p>调用Servlet原生API请求</p>
            <a href="originServlet/servletTest">servlet原生API</a>
        </div>
        <div>
            <p>RequestParam API</p>
            <a href="originServlet/testRequestParam?name=Coolkie">testRequestParam</a>
        </div>
        <div>
            <p>RequestBody API</p>
            <form action="originServlet/testRequestBody" method="post">
                姓名：<input type="text" name="username" /></br>
                年龄：<input type="text" name="age" /></br>
                <input type="submit" value="提交" />
            </form>
        </div>
        <div>
            <p>PathVariable API， REST风格的请求</p>
            <a href="originServlet/testPathVariable/10">testPathVariable</a>
        </div>
        <div>
            <p>RequestHeader API</p>
            <a href="originServlet/testRequestHeader">testRequestHeader</a>
        </div>
        <div>
            <p>CookieValue API</p>
            <a href="originServlet/testCookieValue">testCookieValue</a>
        </div>
        <div>
            <p>ModelAttribute API, 执行效果是在用户提交表单数据之前，对没有赋值的属性，会从缓存或者持久化卷里去拿值</p>
            <form action="originServlet/testModelAttribute" method="post">
                姓名：<input type="text" name="uname" /></br>
                年龄：<input type="text" name="age" /></br>
                <input type="submit" value="提交" />
            </form>
        </div>
        <div>
            <p>SessionAttributes API, 将值传到request请求中，当转到另一个页面的时候，可以把值取出来</p>
            <a href="originServlet/setSessionAttributes">setSessionAttributes</a><br>
            <a href="originServlet/getSessionAttributes">getSessionAttributes</a><br>
            <a href="originServlet/deleteSessionAttributes">deleteSessionAttributes</a><br>
        </div>

    </body>

    </html>