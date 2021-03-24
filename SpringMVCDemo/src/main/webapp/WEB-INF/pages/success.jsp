<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
    <html>

    <head>
        <title>Title</title>
    </head>

    <body>

        <h3>入门成功</h3>
        <script>
            var student = {
                "name": "张三",
                "age": "18"
            };
        // alert(student);
        // var stuJson = JSON.stringify(student);
        // alert("学生信息:"+ stuJson);
        // alert("数据类型:"+ typeof stuJson);
        // alert("姓名:"+ student.name);
        </script>
        <p>${ requestScope.msg }，欢迎你！</p>



        <p>若要显示出来requestScope，则需要开启EL表达式，在开头配：isELIgnored="false" <br>
            $requestScope： <br>
            ${ requestScope }
        </p>

        <p>若要把值存到类下，则会在session中存入这个键值对，实现方法之间的共享 <br>
            $sessionScope： <br>
            ${ sessionScope }
        </p>




    </body>

    </html>