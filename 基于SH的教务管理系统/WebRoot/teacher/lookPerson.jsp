<%@ page language="java" import="java.util.*,PO.Teacher" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'lookPerson.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	*{
	text-decoration: none;
	font-family:微软雅黑;
	}
	</style>
  </head>
  
  <body     style="
	background:url('images/中间.png');
    background-repeat: no-repeat;
    background-size: cover;"
  >
  <center>
  <h2>查看个人信息</h2>
  <br>
  <br>
  <br>
  <% Teacher tea=(Teacher)session.getAttribute("teacher"); %>
  <table     border="1" cellpadding="0" 
    cellspacing="0" 
    style="background-color:#f5f6f8;">
  <tr><td>教师号:</td><td><%=tea.getTeaId() %></td></tr>
  <tr><td>姓名:</td><td><%=tea.getUsername() %></td></tr>
  <tr><td>邮箱:</td><td><%=tea.getEmail() %></td></tr>
  <tr><td>电话:</td><td><%=tea.getTel() %></td></tr>
  </table>
  </center>
  </body>
</html>
