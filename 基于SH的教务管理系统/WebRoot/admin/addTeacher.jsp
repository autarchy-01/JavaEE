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
    
    <title><s:text name="教务管理系统-添加"></s:text></title>
    
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
  <h2>添加教师信息</h2>
  <br>
  <br>
  <br>
  <s:form action="addTeacherAction" method="post">
  <input type="text" name="id" placeholder="请输入教师号" maxlength="16" style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679; width: 170px"><br><br>
  <input type="text" name="name" placeholder="请输入姓名" style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679; width: 170px"><br><br>
  <input type="text" name="password" placeholder="请输入密码" style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679; width: 170px"><br><br>
  <input type="text" name="tel" placeholder="请输入电话" style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679; width: 170px"><br><br>
  <input type="submit" value="提交" style="background-color:#396ebe;
    font-size:17;
    font-family:微软雅黑;
    color:white;
    border-radius:5px;
    outline:none;
    border:0px; 
    width: 165px; 
    height: 35px"><br><br>
  <input type="reset" value="清除" style="background-color:#396ebe;
    font-size:17;
    font-family:微软雅黑;
    color:white;
    border-radius:5px;
    outline:none;
    border:0px; 
    width: 165px; 
    height: 35px"><br><br>
  </s:form>
  </center>
  </body>
</html>
