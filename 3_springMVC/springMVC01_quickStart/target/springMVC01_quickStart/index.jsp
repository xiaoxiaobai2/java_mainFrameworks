<%--
  Created by IntelliJ IDEA.
  User: zhanghao
  Date: 2019/12/18
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--    <h3>快速入门</h3>--%>
<%--    <a href="hello">hello Spring MVC</a>--%>


    <!-- 封装引用类型的参数 、封装集合参数
    <form action="param/testParam" method="post">
        用户名<input type="text" name="user.username"><br>
        年龄<input type="text" name="user.age"><br>
        金额<input type="text" name="money"><br>
        姓名<input type="text" name="list[0].username"><br>
        年龄<input type="text" name="list[0].age"><br>
        姓名<input type="text" name="map['one'].username"><br>
        年龄<input type="text" name="map['one'].age"><br>
        <input type="submit" value="提交"><br>
    </form>
    -->

    <!-- 自定义参数类型转换测试

    <form action="param/testConvert" method="post">
        用户名<input type="text" name="username"><br>
        年龄<input type="text" name="age"><br>
        生日<input type="text" name="birthday"><br>
        <input type="submit" value="提交">
    </form>

     -->

    <!-- 测试获取原生的 request he response -->
    <a href="getRequest">测试获取原生的 request he response</a>

</body>
</html>
