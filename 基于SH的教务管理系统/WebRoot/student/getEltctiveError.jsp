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
    
    <title>My JSP 'error.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	var x=3;
	onload=function(){
	setInterval(function() {
	x--;
	if(x>0){
	document.getElementById("time").innerHTML=x;
	}else{
	location.href="lookElectiveAction"
	}
	}, 1000)
	}
	</script>

  </head>
  
  <body>
    <h3 style="font-family:微软雅黑;">你的选课数已达上限或你已选该门课程,页面将在<span id="time" style="color:red">3</span>秒后跳转到查看已选选课页面</h3>
  </body>
</html>
