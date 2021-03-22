<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>请求参数绑定</h3>
    <div>
        <p>所谓请求参数绑定是利用java的反射机制，将前端发送的请求参数按照一定的参数类型返回到处理请求方法的参数中</p>
        <a href="param/testParam?username=Coolkie&password=123">请求参数绑定</a>
    </div>
    <div>
        <p>发送的请求参数封装到类中</p>
        <form action="param/saveAccount" method="post">
            姓名：<input type="text" name="username"/></br>
            密码：<input type="text" name="password"/></br>
            薪资：<input type="text" name="money"/></br>
            用户姓名：<input type="text" name="user.uname"/></br>
            用户年龄：<input type="text" name="user.age"/></br>
            <input type="submit" value="提交"/>
        </form>
    </div>
    <div>
        <p>发送的请求参数封装到Map和List中</p>
        <form action="param/saveAccount" method="post">
            姓名：<input type="text" name="username"/></br>
            密码：<input type="text" name="password"/></br>
            薪资：<input type="text" name="money"/></br>
            用户1姓名：<input type="text" name="users[0].uname"/></br>
            用户1年龄：<input type="text" name="users[0].age"/></br>
            用户2姓名：<input type="text" name="userMap['one'].uname"/></br>
            用户2年龄：<input type="text" name="userMap['one'].age"/></br>
            <input type="submit" value="提交"/>
        </form>
    </div>

    <div>
        <p>自定义属性类型，当现有的属性不能满足转换需求时，可以按照自定义的转换方式进行转换</p>
        <form action="param/saveUser" method="post">
            用户1姓名：<input type="text" name="uname"/></br>
            用户1年龄：<input type="text" name="age"/></br>
            用户1日期：<input type="text" name="date"/></br>
            <input type="submit" value="提交"/>
        </form>
    </div>

</body>
</html>