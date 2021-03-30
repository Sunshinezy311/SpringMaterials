<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <title>Title</title>
        <script src="js/jquery.min.js"></script>
    </head>

    <body>

        <h3>入门程序</h3>
        <div>
            <h5>当返回值为String类型的时候，在request的处理方法中将结果放入Model中，可以在jsp文件中使用EL表达式中取出结果</h5>
            <a href="user/testString">测试返回String</a>
        </div>

        <div>
            <h5>对于没有返回值的情况，默认情况下不设置任何值，会访问testVoid.jsp文件，即提交请求作为路径，如果不存在则报404错误</h5>
            <a href="user/testVoidByForward">测试testVoidByForward，跳转到另一个页面</a><br>
            <a href="user/testVoid1ByRedirect">测试testVoid1ByRedirect,直接返回页面自己</a><br>
            <a href="user/testVoid1ByDirect">测试testVoid1ByDirect，直接在代码中注入一个新的页面</a><br>
        </div>

        <div>
            <h5>SpringMVC提供了ModelAndView用于相应请求的跳转页面。相应结果封装在ModelAndView实例中</h5>
            <a href="user/testModelAndView">测试testModelAndView</a>
        </div>

        <div>
            <h5>使用forward和redirect关键字实现页面的转发和重定向</h5>
            <a href="user/testForward">测试testForward</a><br>
            <a href="user/testRedirect">测试testRedirect</a>
        </div>

        <div>
            <h5>基于js使用button实现一个ajax请求</h5>
            <script>
                //页面加载，绑定一个单击事件
                $(function () {
                    $("#btn").click(function () {
                        $.ajax({
                            url: "user/testAjax",
                            contentType: "application/json;charset=UTF-8",
                            data: '{"username":"毛毛姐","password":"******","age":28}',
                            dataType: "json",
                            type: "post",
                            success: function (data) {
                                alert("点击按钮发送ajax响应的结果：\n" + data.username + "\n" + data.age+ "\n" + data.password);
                            }
                        });
                    });
                });
            </script>
            <button id="btn">发送ajax请求</button>
        </div>
    </body>

    </html>