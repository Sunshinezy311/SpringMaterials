<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <title>Title</title>
        <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
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
                姓名：<input type="text" name="username" /></br>
                密码：<input type="text" name="password" /></br>
                薪资：<input type="text" name="money" /></br>
                用户姓名：<input type="text" name="user.uname" /></br>
                用户年龄：<input type="text" name="user.age" /></br>
                <input type="submit" value="提交" />
            </form>
        </div>
        <div>
            <p>发送的请求参数封装到Map和List中</p>
            <form action="param/saveAccount" method="post">
                姓名：<input type="text" name="username" /></br>
                密码：<input type="text" name="password" /></br>
                薪资：<input type="text" name="money" /></br>
                用户1姓名：<input type="text" name="users[0].uname" /></br>
                用户1年龄：<input type="text" name="users[0].age" /></br>
                用户2姓名：<input type="text" name="userMap['one'].uname" /></br>
                用户2年龄：<input type="text" name="userMap['one'].age" /></br>
                <input type="submit" value="提交" />
            </form>
        </div>

        <div>
            <p>自定义属性类型，当现有的属性不能满足转换需求时，可以按照自定义的转换方式进行转换</p>
            <form action="param/saveUser" method="post">
                用户1姓名：<input type="text" name="uname" /></br>
                用户1年龄：<input type="text" name="age" /></br>
                用户1日期：<input type="text" name="date" /></br>
                <input type="submit" value="提交" />
            </form>
        </div>

        <h3>ajax实现请求参数发送与返回</h3>
        <div>
            <h5>基于js使用button实现一个ajax请求，ajax是一个异步请求</h5>
            <script>
                //页面加载，绑定一个单击事件
                $(function () {
                    $("#btn").click(function () {
                        $.ajax({
                            url: "param/testAjax",
                            contentType: "application/json;charset=UTF-8",
                            data: '{"username":"毛毛姐","password":"******","age":28}',
                            dataType: "json",
                            type: "post",
                            success: function (data) {
                                alert("点击按钮发送ajax响应的结果：\n" + data.username + "\n" + data.age + "\n" + data.password);
                            }
                        });
                    });
                });
            </script>
            <button id="btn">发送ajax请求</button>
        </div>

        <h3>上传文件</h3>
        <div>
            <p>上传文件，有以下几个必要条件：<br>
                1.form表单的enctype（表单请求正文的类型）取值必须是multipart/form-data。<br>
                2.method必须是POST
                3.必须提供一个文件选择域：&lt;input type="file" /&gt;
            </p>
            <h5>传统上传文件的方式</h5>
            <form action="fileUpload/fileUploadByTraditionWay" method="post" enctype="multipart/form-data">
                选择文件：<input type="file" name="upload" /></br>
                上传：<input type="submit" value="上传" /></br>
            </form>
            <h5>SpringMVC上传文件的方式，需要配置文件解析器</h5>
            <form action="fileUpload/fileUploadBySpringWay" method="post" enctype="multipart/form-data">
                <!-- 注意选择文件中的name叫upload，则调用的方法名中传入的参数也必须叫upload -->
                选择文件：<input type="file" name="upload" /></br>
                上传：<input type="submit" value="上传" /></br>
            </form>
        </div>

    </body>

    </html>