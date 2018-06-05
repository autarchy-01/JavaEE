<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <center>
  <h3>课程信息</h3>
  <table border="4">
  <tr>
  <th>时间</th>
  <th>课程</th>
  <th>地点</th>
  </tr>
  <%
  ArrayList list=(ArrayList)session.getAttribute("course");
  if(list.isEmpty()){
   %>
   <tr>
   <td><span>暂无课程信息</span></td>
   </tr>
   <%
   }else{
   for(int i=0;i<list.size();i++){
   Object obj[]=(Object[])list.get(i);
    %>
   <tr>
    <td><%=obj[0] %></td>
    <td><%=obj[1] %></td>
    <td><%=obj[2] %></td>
    </tr>
    <%
    }
    }
     %>
  </table>
  </center>
  </body>
</html>
