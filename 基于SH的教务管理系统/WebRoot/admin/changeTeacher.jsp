<%@page import="PO.Teacher"%>
<%@page import="PO.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>changeScore</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	*{
	text-decoration: none;
	font-family:微软雅黑;
	}
	</style>

  </head>
  <body style="
	background:url('images/中间.png');
    background-repeat: no-repeat;
    background-size: cover;">
  <center>
  <h2>修改</h2>
  <br>
  <br>
  <br>
  <form action="changeTeacherAction" method="post">
  <%Teacher tea=(Teacher)session.getAttribute("teacher"); %>
  <input name="id" placeholder="请输入学号" readonly="readonly" value="<%=tea.getTeaId() %>" style="border-radius:5px; 
	height: 30px;
	width: 170px; 
	outline:none;
	border:2px solid #666679;"/><br><br>
  <input name="name" placeholder="请输入姓名" value="<%=tea.getUsername() %>" style="border-radius:5px; 
	height: 30px;
	width: 170px; 
	outline:none;
	border:2px solid #666679;"/><br><br>
  <input name="password" placeholder="请输入密码" value="<%=tea.getPassword() %>" style="border-radius:5px; 
	height: 30px;
	width: 170px; 
	outline:none;
	border:2px solid #666679;"/><br><br>
  <input name="tel" placeholder="请输入电话" value="<%=tea.getTel() %>" style="border-radius:5px; 
	height: 30px;
	width: 170px; 
	outline:none;
	border:2px solid #666679;"/><br><br>
 <input type="submit" value="修改" style="background-color:#396ebe;
    font-size:17;
    font-family:微软雅黑;
    color:white;
    border-radius:5px;
    outline:none;
    border:0px; 
    width: 170px; 
    height: 30px"/>
  </form>
  </center>
  </body>
</html>

