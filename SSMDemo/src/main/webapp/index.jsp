<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <title>Title</title>
        <script src="js/jquery.min.js"></script>
    </head>

    <body>

        <h3>测试数据库findAll查找所有的对象</h3>
        <div>
            <h5>当返回值为String类型的时候，在request的处理方法中将结果放入Model中，可以在jsp文件中使用EL表达式中取出结果</h5>
            <a href="account/findAll">测试findAll</a>
        </div>

        <h3>测试数据库save保存对象</h3>
        <div>
            <h5>保存一组数据</h5>
            <form action="account/save" method="POST">
                姓名: <input type="text" name="name" /><br />
                金额: <input type="text" name="money" /><br />
                <input type="submit" value="保存" /><br />
            </form>
        </div>
    </body>

    </html>