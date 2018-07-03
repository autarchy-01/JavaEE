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

  </head>
  
  <body bgcolor="pink">
  <center>
  <s:div>
  <br>
  <font color="red" size="6">添加教师信息</font>
  </s:div>
  <s:form action="addTeacherAction" method="post">
  <table width="30%" bgcolor="gray" border="5">
  <tr>
  <td><s:textfield name="id" label="教师号" maxlength="16"></s:textfield></td>
  <td><s:textfield name="name" label="姓名"></s:textfield></td>
  <td><s:textfield name="password" label="密码"></s:textfield></td>
  <td><s:textfield name="tel" label="电话"></s:textfield></td>
  <td colspan="2">
  <s:submit value="提交"></s:submit>
  <s:reset value="清除"></s:reset>
  </td>
  </tr>
  </table>
  </s:form>
  </center>
  </body>
</html>
