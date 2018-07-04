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
		<style type="text/css">
	*{
	text-decoration: none;
	font-family:微软雅黑;
	}
	</style>

  </head>
  <body style="
	background:url('images/中间.png');
    background-repeat: no-repeat;
    background-size: cover;"
  >
  <center>
  <h2>修改</h2>
  <br>
  <br>
  <br>
  <s:form action="changeScoreAction" method="post">
  <input type="text" name="stuId"
    style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679;" 
	value="<%=(Integer)session.getAttribute("stuId")%>" readonly="readonly"><br><br>
  <input type="text" name="couId"	style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679;"  
	value="<%=(Integer)session.getAttribute("couId")%>" readonly="readonly"><br><br>
  <input type="text" name="score" 	
    style="border-radius:5px; 
	height: 30px;
	outline:none;
	border:2px solid #666679;"
	 value="<%=(Integer)session.getAttribute("score")%>">
	 <br><br>
  <s:submit value="修改" style="background-color:#396ebe;
    font-size:17;
    font-family:微软雅黑;
    color:white;
    border-radius:5px;
    outline:none;
    border:0px; 
    width: 145px; 
    height: 30px"/>
  </s:form>
  </center>
  </body>
</html>
