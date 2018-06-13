<%@ page language="java" import="java.util.*,PO.Student" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
 <body>
  <center>
  <h3>查看个人信息</h3>
  <br>
  <hr>
  <% Student stu=(Student)session.getAttribute("student"); %>
  <table>
  <tr><td>学号:</td><td><%=stu.getStuId() %></td></tr>
  <tr><td>姓名:</td><td><%=stu.getUsername() %></td></tr>
  <tr><td>性别:</td><td><%=stu.getSex() %></td></tr>
  <tr><td>院系:</td><td><%=stu.getDepartment() %></td></tr>
  <tr><td>籍贯:</td><td><%=stu.getJiguan() %></td></tr>
  <tr><td>邮箱:</td><td><%=stu.getEmail() %></td></tr>
  <tr><td>电话:</td><td><%=stu.getTel() %></td></tr>
  </table>
  </center>
  </body>
</html>
