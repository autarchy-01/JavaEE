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
    
    <title>教务管理系统-登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/login.css">
  </head>
  
  <body style="background: url('images/登录页面2.jpg') no-repeat;">
  <s:form action="loginAction" method="post">
  <table class="style1">
  <tr>
  <td><span>用户:</span></td>
   <td><input type="text" name="sno"></td>
    <td><label><input type="radio" name="radiobutton" value="1" checked="checked">学生</label></td>
  </tr>
    <tr>
  <td><span>密码:</span></td>
   <td><input type="password" name="password"></td>
    <td><label><input type="radio" name="radiobutton" value="2" checked="checked">教师</label></td>
  </tr>
      <tr>
  <td><input type="submit" value="登录"></td>
   <td><input type="reset" value="重置"></td>
    <td><label><input type="radio" name="radiobutton" value="3" checked="checked">管理员</label></td>
  </tr>
  </table>
  </s:form>
  </body>
</html>
