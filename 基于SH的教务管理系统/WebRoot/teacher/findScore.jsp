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

  </head>
  <body>
  <center>
  <h3>搜索要修改的学生学号和课程号</h3>
  <s:form action="findScoreAction" method="post">
  <s:label value="学号"/><s:textfield name="stuId"></s:textfield>
  <s:label value="课程号"/><s:textfield name="couId"></s:textfield>
  <s:submit value="查询"></s:submit>
  </s:form>
  </center>
  </body>
</html>
