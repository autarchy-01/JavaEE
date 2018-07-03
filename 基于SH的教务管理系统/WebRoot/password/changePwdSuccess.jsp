<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>" target="_top">
    
    <title>My JSP 'success.jsp' starting page</title>
    
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
	top.location.href="<%=request.getContextPath()%>/index.jsp"
	}
	}, 1000)
	}
	</script>

  </head>
  
  <body>
    <h3>密码修改成功,<span id="time">3</span>秒后跳转到登录页面!</h3>
  </body>
</html>
