<%@ page language="java" import="java.util.*,PO.Course,Dao.StudentDao" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'lookElective.jsp' starting page</title>
    
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
  <h3>查看选修课</h3>
  <br>
  <hr>
   <table border="5">
  <tr>
  <th>课程号</th>
  <th>课程名</th>
  <th>教室</th>
  <th>时间</th>
  </tr>
  <% 
  StudentDao dao=new StudentDao();
  ArrayList list=(ArrayList)session.getAttribute("lookElective");
  if(list.isEmpty()){
   %>
   <tr>
   <td><span>暂无课程信息</span></td>
   </tr>
   <%
   }else{
   for(int i=0;i<list.size();i++){
   Course cou=(Course)list.get(i);
    %>
    <tr>
    <td><%=cou.getCouId() %></td>
    <td><%=cou.getCouName() %></td>
    <td><%=cou.getRoom() %></td>
    <td><%=cou.getTime() %></td>
    </tr>
    <%
    }
    }
    %>
  </table>
  </center>
  </body>
</html>
