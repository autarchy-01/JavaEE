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
    
    <title>findScore</title>
    
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
  <body  style="
	background:url('images/中间.png');
    background-repeat: no-repeat;
    background-size: cover;">
  <center>
  <h2>搜索要修改的学生学号</h2>
  <br>
  <br>
  <br>
  <form action="findStudentAction" method="post">
  学号&nbsp;:&nbsp;<input type="text" placeholder="请输入学号" name="stuId" style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679;"/>&nbsp;&nbsp;
  <input type="submit" value="查询" style="background-color:#396ebe;
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
