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
	<style type="text/css">
	*{
	text-decoration: none;
	font-family:微软雅黑;
	}
	</style>

  </head>
  <body>
  <center>
  <h3>修改</h3>
  <s:form action="changeStudentAction" method="post">
  <%Student stu=(Student)session.getAttribute("student"); %>
  学号&nbsp;:&nbsp;<input name="id" readonly="readonly" value="<%=stu.getStuId() %>" style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679;"/><br><br>
  姓名&nbsp;:&nbsp;<input name="name" value="<%=stu.getUsername() %>" style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679;"/><br><br>
  密码&nbsp;:&nbsp;<input name="password" value="<%=stu.getPassword() %>" style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679;"/><br><br>
  性别&nbsp;:&nbsp;<input name="sex" value="<%=stu.getSex() %>" style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679;"/><br><br>
  系别&nbsp;:&nbsp;<input name="department" value="<%=stu.getDepartment() %>" style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679;"/><br><br>
  籍贯&nbsp;:&nbsp;<input name="jiguan" value="<%=stu.getJiguan() %>" style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679;"/><br><br>
  电话&nbsp;:&nbsp;<input name="tel" value="<%=stu.getTel() %>" style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679;"/><br><br>
  选课&nbsp;:&nbsp;<input name="max" value="<%=stu.getMax() %>" style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679;"/><br><br>
 <input type="submit" value="修改" style="background-color:#396ebe;
    font-size:17;
    font-family:微软雅黑;
    color:white;
    border-radius:5px;
    outline:none;
    border:0px; 
    width: 180px; 
    height: 30px"/>
  </s:form>
  </center>
  </body>
</html>
