<%@page import="Dao.StudentDao"%>
<%@page import="PO.Course"%>
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
    
    <title>My JSP 'getElective.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body style="
	background:url('images/中间.png');
    background-repeat: no-repeat;
    background-size: cover;">
  <center>
  <s:form action="setElectiveAction" method="post">
  <h2 style="font-family:微软雅黑;">选择选修课</h2>
  <br>
  <br>
  <br>
   <table     border="1" cellpadding="0" 
    cellspacing="0" 
    style="background-color:#f5f6f8; width: 645px">
    <tr>
  <th>选择</th>
  <th>课程号</th>
  <th>课程名</th>
  <th>选课人数</th>
  </tr>
  <% 
  StudentDao dao=new StudentDao();
  ArrayList list=(ArrayList)session.getAttribute("elective");
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
    <td><input type="radio" name="radiobutton" value="<%=cou.getCouId() %>" checked="checked"></td>
    <td><%=cou.getCouId() %></td>
    <td><%=cou.getCouName() %></td>
    <td><%=dao.getNumber(cou.getCouId()) %>/<%=cou.getMax() %></td>
    </tr>
    <%
    }
    }
    %>
    </table>
    <br>
    <table>
    <tr><td><input type="submit" value="提交" style="background-color:#396ebe;
    font-size:17;
    font-family:微软雅黑;
    color:white;
    border-radius:5px;outline:none;
    border:0px; width: 91px; height: 35px"></td></tr>
  </table>
    </s:form>
  </center>
  </body>
</html>
