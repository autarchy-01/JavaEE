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
    background-size: cover;"
  >
  <center>
  <h2>设置你的新密码</h>
  <br>
  <br>
  <br>
  <form action="changePwdAction">
  <input type="text" name="password" placeholder="请输入新的密码"
  style="border-radius:5px; height: 30px;outline:none;border:2px solid #666679;"
  >
&nbsp;
  <input type="submit" value="提交" style="background-color:#396ebe;
    font-size:17;
    font-family:微软雅黑;
    color:white;border-radius:5px;outline:none;border:0px; height: 30px"
  >
  </form>
  </center>
  </body>
</html>