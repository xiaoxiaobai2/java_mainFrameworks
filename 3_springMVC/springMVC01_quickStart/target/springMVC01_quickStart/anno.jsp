<%--
  Created by IntelliJ IDEA.
  User: zhanghao
  Date: 2019/12/18
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Anno</title>
</head>
<body>
    <!-- testRequestParam -->
    <a href="Anno/testRequestParam?username=张浩">testRequestParam</a><br><br>

    <form action="Anno/testRequestBody" method="post">
        姓名<input type="text" name="username"><br>
        年龄<input type="text" name="age"><br>
        <input type="submit" value="testRequestBody"><br>
    </form>
    <br><br>

    <!-- testPathVariable -->
    <a href="Anno/testPathVariable/100">testPathVariable</a><br><br>

    <!-- testRequestHeader -->
    <a href="Anno/testRequestHeader">testRequestHeader</a><br><br>

    <!-- testCookieValue -->
    <a href="Anno/testCookieValue">testCookieValue</a><br><br>

    <form action="Anno/testModelAttribute" method="post">
        姓名<input type="text" name="username"><br>
        年龄<input type="text" name="age"><br>
        <input type="submit" value="testModelAttribute"><br>
    </form>
    <br><br>

    <!-- testSessionAttributes -->
    <a href="Anno/testSessionAttributes?msg=妹妹">testSessionAttributes</a>
    <a href="Anno/getSessionAttribute">getSessionAttribute</a>
    <a href="Anno/deleteSessionAttribute">deleteSessionAttributes</a>

</body>
</html>
