<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>入门成功</h3>
    <script>
        var student={
            "name":"张三",
            "age":"18"
        };
        alert(student);
        var stuJson = JSON.stringify(student);
        alert("学生信息:"+ stuJson);
        alert("数据类型:"+ typeof stuJson);
        alert("姓名:"+ student.name);
    </script>

    ${ msg }

    ${sessionScope}

</body>
</html>