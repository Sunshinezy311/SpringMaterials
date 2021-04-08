<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>

    <head>
        <title>Title</title>
        <script src="js/jquery.min.js"></script>
    </head>

    <body>
        <h2>跨服务器上传文件方式</h2>
        <h3>上传文件</h3>
        <div>
            <p>跨服务器上传文件：<br>
            </p>
            <h5>SpringMVC上传文件的方式，需要配置文件解析器</h5>
            <form action="fileUpload/fileUploadThroughServer" method="post" enctype="multipart/form-data">
                <!-- 注意选择文件中的name叫upload，则调用的方法名中传入的参数也必须叫upload -->
                选择文件：<input type="file" name="upload" /></br>
                上传：<input type="submit" value="上传" /></br>
            </form>
        </div>
    </body>

    </html>