<%--
  Created by IntelliJ IDEA.
  User: lvbingxing
  Date: 2020/4/29
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<center>
    <form action="upload" enctype="multipart/form-data" method="post">
        请选择文件：<input type="file" name="filename" multiple><br>
        <input type="submit" value="上传">
    </form>

</center>
</body>
</html>
