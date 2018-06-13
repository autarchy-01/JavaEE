<%@ page language="java" import="java.util.*,PO.Selclass,PO.SelclassId" pageEncoding="UTF-8"%>
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
  <s:form action="changeScoreAction" method="post">
  学号:&nbsp;<input type="text" name="stuId" size="18" value="<%=(Integer)session.getAttribute("stuId")%>" readonly="readonly"><br><br>
  课程号:&nbsp;<input type="text" name="couId" size="16" value="<%=(Integer)session.getAttribute("couId")%>" readonly="readonly"><br><br>
  成绩:&nbsp;<input type="text" name="score" size="18" value="<%=(Integer)session.getAttribute("score")%>">
  <s:submit value="修改"/>
  </s:form>
  </center>
  </body>
</html>
