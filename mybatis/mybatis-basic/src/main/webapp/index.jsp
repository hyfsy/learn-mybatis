<%@ page import="com.hyf.mybatis.mapper.UserMapper" %>
<%@ page import="com.hyf.mybatis.pojo.User" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.Reader" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: baB_hyf
  Date: 2020-01-20
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Test JNDI</title>
</head>
<body>
    <%
        SqlSession sqlSession = null;
        try {
            Reader reader = Resources.getResourceAsReader("conf/mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

            sqlSession = sqlSessionFactory.openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = mapper.selectAllUser();
            System.out.println(users);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    %>
</body>
</html>
