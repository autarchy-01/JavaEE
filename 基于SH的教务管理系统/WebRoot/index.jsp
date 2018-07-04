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
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" type="text/css" href="css/login.css">
  </head>
  
  <body style="
               background:url('images/登录页面.png');
               background-repeat: no-repeat;
               background-size: cover;
               ">
  <s:form action="loginAction" method="post">
  <table class="style1" cellspacing="14">
  <tr>
   <td>
   <input type="text" name="sno" placeholder="请输入用户名"class="username" 
    style="
    background:url(images/用户名.png)no-repeat scroll left center transparent;
    border:2px solid #2f73d8;float:left;border-radius:5px; width: 300px">
    </td>
  </tr>
    <tr>
   <td><input type="password" name="password"  placeholder="请输入密码"  class="password"
    style="
    background:url(images/密码.png)no-repeat scroll left center transparent;
    border:2px solid #2f73d8;float:left; border-radius:5px; width: 300px">
   </td>
  </tr>
  <tr>
  <td colspan="10" style="width: 386px; "><span style="font-size:20;color:#003366;">权限:</span>
    <select name="radiobutton" style="width: 250px; height: 40px; outline:none;
     font-size: 18px; 
     color:#003366;
     background-color: #f4f4f4;
     border-radius:4px;">
    <option value="1">学        生</option>
    <option value="2">教        师</option>
    <option value="3">管   理  员</option>
    </select></td>
  </tr>
      <tr>
  <td><input type="submit" value="登  录" class="login" style="background-color:#396ebe;
  border-radius:5px;outline:none;border:0px"></td>
  </tr>
  <tr>
   <td ><input type="reset" value="重  置" class="login"style="background-color:#396ebe ;
   border-radius:5px;outline:none;border:0px"></td>
  </tr>
  </table>
  </s:form>
  </body>
</html>
