<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h3>入门程序</h3>
    <div>
        <a href="user/hello">入门程序入口</a>
    </div>
    <div>
        <a href="user/testRequestMapping">RequestMapping注解</a>
    </div>
    <div>
        <p>注意传入的参数是大小写敏感的</p>
        <a href="user/testRequestMappingWithParams?username=coolkie">带有参数的RequestMapping注解</a>
    </div>
    <div>
        <p>注意RequestMapping中有固定的key和value，则对应有该key和value值的请求就只走对应的这个Mapping</p>
        <a href="user/testRequestMappingWithParams1?username=coolkie">带有参数的RequestMapping注解</a>
    </div>
    <div>
        <p>注意RequestMapping中有固定Headers，则只能传发送的请求头中包含有该Header的</p>
        <a href="user/testRequestMappingWithParamsAndHeaders?username=coolkie">带有参数的RequestMapping注解</a>
    </div>
</body>
</html>