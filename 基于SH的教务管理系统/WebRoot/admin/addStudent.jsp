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
    background-size: cover;">
  <center>
<h2>添加学生</h2>
<br>
<br>
<br>
  <s:form action="addStudentAction" method="post">
  <input type="text" name="id" placeholder="学号" maxlength="16"style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679; width: 170px"><br><br>
  <input type="text" name="name" placeholder="姓名"style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679; width: 170px"><br><br>
  <input type="text" name="password" placeholder="密码"style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679; width: 170px"><br><br>
  <select  name="sex" style="width: 170px; height: 30px; outline:none;
     font-size: 18px; 
     color:#003366;
     background-color: #f4f4f4;
     border-radius:4px;">
  <option value="男">男</option>
  <option value="女">女</option>
  </select><br><br>
  <input type="text" name="department" placeholder="系别"style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679; width: 170px"><br><br>
  <input type="text" name="jiguan" placeholder="籍贯"style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679; width: 170px"><br><br>
  <input type="text" name="tel" placeholder="电话"style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679; width: 170px"><br><br>
  <input type="text" name="max" placeholder="选课数目"style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679; width: 170px"><br><br>
  <input type="submit" style="background-color:#396ebe;
    font-size:17;
    font-family:微软雅黑;
    color:white;
    border-radius:5px;
    outline:none;
    border:0px; 
    width: 160px; 
    height: 35px" value="提交"><br><br>
  <input type="reset"style="background-color:#396ebe;
    font-size:17;
    font-family:微软雅黑;
    color:white;
    border-radius:5px;
    outline:none;
    border:0px; 
    width: 160px; 
    height: 35px" value="清除">
  </s:form>
  </center>
  </body>
</html>
