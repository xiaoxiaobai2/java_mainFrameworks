<%--
  Created by IntelliJ IDEA.
  User: zhanghao
  Date: 2020/1/6
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>传统方式上传文件</h3>
    <form action="user/testUpload1" method="post" enctype="multipart/form-data">
        <input type="file" value="上传文件" name="upload">
        <input type="submit" name="submit" value="上传">
    </form>

    <h3>SpringMVC上传文件</h3>
    <form action="user/testUpload2" method="post" enctype="multipart/form-data">
        <input type="file" value="上传文件" name="upload">
        <input type="submit" name="submit" value="上传2">
    </form>

    <h3>跨服务器上传文件</h3>
    <form action="user/testUpload3" method="post" enctype="multipart/form-data">
        <input type="file" value="上传文件" name="upload">
        <input type="submit" name="submit" value="上传3">
    </form>
</body>
</html>
