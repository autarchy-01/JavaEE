<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>教务管理系统-教师</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	body{
	scrollbar-base-color:#c0d586;
	scrollbar-arrow-color:#ffffff;
	scrollbar-shadow-color:#deefc6;
	
	}
	</style>

  </head>
  
<frameset rows="80,*" cols="*" frameborder="no" border="0"framespacing="0">
<frame src="<%=request.getContextPath()%>/top.jsp" name="topFrame" scrolling="no">
<frameset cols="200,*" name="btFrame" frameborder="no" border="0"framespacing="0">
<frame src="<%=request.getContextPath()%>/teacher/tea_menu.jsp" noresize name="menu" scrolling="yes">
<frame src="<%=request.getContextPath()%>/main.jsp" noresize name="main" scrolling="yes">
</frameset>
</frameset>
<noframes>
<body>你的浏览器不支持框架!</body>
</noframes>
</html>
