<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>top</title>
    
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
  <table bgcolor="cyan" width="100%" border="0" cellpadding="0" cellspacing="0" background="">
  <tr>
  <td width="20%" height="60"><h2>教务管理系统</h2></td>
  <td width="80%" align="right" valign="bottom">
  <table width="750" border="0" cellpadding="0" cellspacing="0">
  <tr>
  <td align="right" height="26" style="padding-right: 10px;line-height: 26px;vertical-align: middle;">
  	您好:<span><s:property value="#session.username" /></span>,欢迎登陆教务管理系统!
  	[<a href="<%=request.getContextPath()%>/index.jsp" target="_blank">登录页面</a>]
  	[<a href="#" target="main">修改密码</a>]
  	[<a href="#" target="_top">退出系统</a>]
  	</td>
  </tr>
  </table>
  </td>
  </tr>
  </table>
  <hr>
  
  </body>
</html>
