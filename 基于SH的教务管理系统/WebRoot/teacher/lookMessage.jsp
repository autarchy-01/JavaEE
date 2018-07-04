<%@page import="PO.Student"%>
<%@ page language="java" import="java.util.*,PO.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><s:text name="学生信息管理系统-查看"></s:text></title>
    
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
	<script type="text/javascript">
    
        function validate()
        {
            var page = document.getElementsByName("page")[0].value;
                
            if(page > <s:property value="#request.pageBean.totalPage"/>)
            {
                alert("你输入的页数大于最大页数，页面将跳转到首页！");
                
                window.document.location.href = "lookMessageAction";
                
                return false;
            }
            
            return true;
        }
    
    </script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body     style="
	background:url('images/中间.png');
    background-repeat: no-repeat;
    background-size: cover;">
  <center>
  <h2>学生信息</h2>
  <br>
  <br>
  <br>
  <table width="80%"border="1" cellpadding="0" 
    cellspacing="0" 
    style="background-color:#f5f6f8;">
  <tr>
  <th>学号</th>
  <th>姓名</th>
  <th>性别</th>
  <th>院系</th>
  <th>课程号</th>
  <th>课程名</th>
  <th>成绩</th>
  </tr>
  <%
  ArrayList list=(ArrayList)session.getAttribute("pageList");
  if(list.isEmpty()){
   %>
   <tr>
   <td><span>暂无学生信息</span></td>
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
    <td><%=obj[3] %></td>
    <td><%=obj[4] %></td>
    <td><%=obj[5] %></td>
    <td><%=obj[6] %></td>
    </tr>
    <%
    }
    }
     %>
  </table>
  <font size="5">共<font color="red"><s:property value="#request.pageBean.totalPage"/></font>页 </font>&nbsp;&nbsp;
        <font size="5">共<font color="red"><s:property value="#request.pageBean.allRows"/></font>条记录</font><br><br>
        
        <s:if test="#request.pageBean.currentPage == 1">
            首页&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;<s:property value="#request.pageBean.currentPage"/>/<s:property value="#request.pageBean.totalPage"/>&nbsp;&nbsp;&nbsp;
        </s:if>
        
        <s:else>
            <a href="lookMessageAction.action?a=0">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="lookMessageAction.action?page=<s:property value="#request.pageBean.currentPage - 1"/>&a=0">上一页</a>&nbsp;&nbsp;&nbsp;<s:property value="#request.pageBean.currentPage"/>/<s:property value="#request.pageBean.totalPage"/>&nbsp;&nbsp;&nbsp;
        </s:else>
        
        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
            <a href="lookMessageAction.action?page=<s:property value="#request.pageBean.currentPage + 1"/>&a=0">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="lookMessageAction.action?page=<s:property value="#request.pageBean.totalPage"/>&a=0">尾页</a>
        </s:if>
        
        <s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>
        <form action="lookMessageAction" onsubmit="return validate();">
            <input type="text" size="2" 	style="border-radius:5px; 
	        outline:none;
	        border:2px solid #666679; width: 40px; height: 20px"name="page">&nbsp;页
            <input type="hidden" name="a" value="0">
            <input type="submit" value="跳转" 
            style="background-color:#396ebe;
    font-size:17;
    font-family:微软雅黑;
    color:white;
    border-radius:5px;
    outline:none;
    border:0px; 
    width: 50px; 
    height: 25px">
        </form>
  </center>
  </body>
</html>
