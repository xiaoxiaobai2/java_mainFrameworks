<%--
  Created by IntelliJ IDEA.
  User: zhanghao
  Date: 2019/12/19
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                    url:"user/testAjax",
                    contentType:"Application/json;charset=utf-8",
                    data:'{"username":"zhangsan","password":"123","age":25}',
                    datatype:"json",
                    type:"post",
                    success:function (data) {
                        alert(data.username);
                        alert(data.age);
                    }
                })
            });
        })
    </script>
</head>
<body>
    <a href="user/testString">testString</a><br><br>

    <a href="user/testVoid">testVoid</a><br><br>

    <a href="user/testModelAndView">testModelAndView</a><br><br>

    <a href="user/testDispatcherAndRedirect">testDispatcherAndRedirect</a><br><br>

    <button name="send ajax" id="btn" value="send ajax">send ajax</button>
</body>
</html>
