<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.zhanghao.dao.UserDao" %>
<%@ page import="com.zhanghao.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<%
    InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
    SqlSession sqlSession = factory.openSession();
    UserDao userDao = sqlSession.getMapper(UserDao.class);
    List<User> users = userDao.findAll();
    for (User user : users) {
        System.out.println("user = " + user);
    }
    is.close();
    sqlSession.close();
%>
<h2>Hello World!</h2>
</body>
</html>
