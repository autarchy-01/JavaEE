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
  
  <body style="background-color:#396ebe">
  <table width="100%" height="80" border="0" cellpadding="0" cellspacing="0">
  <tr height="60">
  <td width="20%" style="color:white;font-size:19;"><h2>&nbsp;&nbsp;&nbsp;教务管理系统</h2></td>
  <td width="80%" align="right" valign="bottom">
  <table width="750" border="0" cellpadding="0" cellspacing="0">
  <tr>
  <td align="right" height="47" style="padding-right: 10px;line-height: 26px;vertical-align: middle; color:white;">
  	您好:<span><s:property value="#session.username" /></span>,欢迎登陆教务管理系统!
  	[<a href="<%=request.getContextPath()%>/index.jsp" target="_blank" style="text-decoration: none;"><span style="color:#000000;text-decoration: none;">登录页面</span></a>]
  	[<a href="<%=request.getContextPath()%>/password/changePwd.jsp" target="main">修改密码</a>]
  	[<a href="<%=request.getContextPath()%>/index.jsp" target="_top">退出系统</a>]
  	</td>
  </tr>
  </table>
  </td>
  </tr>
  </table>
  <hr> 
  </body>
</html>
