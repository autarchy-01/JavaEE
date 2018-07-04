<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'setEmail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="
	background:url('images/中间.png');
    background-repeat: no-repeat;
    background-size: cover;"
  >
  <center>
  <h2>设置你的Email</h2>
  <br>
  <br>
  <br>
  <form action="setEmailAction">
  <input type="text" name="email" placeholder="请输入你的邮箱" style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679;"/> &nbsp;&nbsp;
	<input type="submit" value="提交" style="background-color:#396ebe;
    font-size:17;
    font-family:微软雅黑;
    color:white;
    border-radius:5px;
    outline:none;
    border:0px; 
    width: 90px; 
    height: 30px"/>
  </form>
  </center>
  </body>
</html>
