<%@page import="PO.Student"%>
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
    
    <title>changeScore</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  <body>
  <center>
  <h3>修改</h3>
  <s:form action="changeStudentAction" method="post">
  <%Student stu=(Student)session.getAttribute("student"); %>
  <table>
  <tr><td>学号<input name="id" readonly="readonly" value="<%=stu.getStuId() %>"/></td></tr>
  <tr><td>姓名<input name="name" value="<%=stu.getUsername() %>"/></td></tr>
  <tr><td>密码<input name="password" value="<%=stu.getPassword() %>"/></td></tr>
  <tr><td>性别<input name="sex" value="<%=stu.getSex() %>"/></td></tr>
  <tr><td>系别<input name="department" value="<%=stu.getDepartment() %>"/></td></tr>
  <tr><td>籍贯<input name="jiguan" value="<%=stu.getJiguan() %>"/></td></tr>
  <tr><td>电话<input name="tel" value="<%=stu.getTel() %>"/></td></tr>
  <tr><td>选课<input name="max" value="<%=stu.getMax() %>"/></td></tr>
 <tr><td><s:submit value="修改"/></td></tr>
  </table>
  </s:form>
  </center>
  </body>
</html>
