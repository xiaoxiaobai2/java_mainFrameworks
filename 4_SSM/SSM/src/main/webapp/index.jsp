<%--
  Created by IntelliJ IDEA.
  User: zhanghao
  Date: 2020/1/7
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/findAll">测试查询所有</a>

    <form action="account/save" method="post">
        姓名：<input type="text" name="name">
        金钱：<input type="text" name="money">
        <input type="submit" name="submit" value="保存账户">
    </form>
</body>
</html>
