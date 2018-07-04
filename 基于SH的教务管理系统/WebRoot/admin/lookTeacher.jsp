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
        //全选
        function checkboxed(name){
        var objNameList=document.getElementsByName(name);
        if(objNameList!=null){
        for(var i=0;i<objNameList.length;i++){
        objNameList[i].checked="checked";
        }
        objNameList.checked="checked";
        }
        }
    //取消全选
    function uncheckboxed(name){
    var objNameList=document.getElementsByName(name);
    if(objNameList!=null){
    for(var i=0;i<objNameList.length;i++){
     objNameList[i].checked="";
        }
    }
    }
    function deletes(name){
    var obj = document.getElementsByName(name);
    var bb="";
    var temp="";
    for(var i=0;i<obj.length;i++){
    if(obj[i].checked){
    temp=obj[i].value;
    if(i==obj.length-1){
    bb+=temp
    }
    else{
        bb+=temp+",";
    }
    }
    }
    alert("你确定要删除这些教师:"+bb+"吗?");
    location.href="deleteTeacherAction?deleteTeacherValue="+bb;
    }
    </script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body     style="
	background:url('images/中间.png');
    background-repeat: no-repeat;
    background-size: cover;"
>
  <center>
  <h2>查看教师信息</h2>
  <br>
  <br>
  <br>
  <table width="60%"     border="1" cellpadding="0" 
    cellspacing="0" 
    style="background-color:#f5f6f8;">
  <tr>
  <th width="15%"><input type="button" onclick="checkboxed('teacher')" value="全选"
    style="background-color:#396ebe;
    font-size:15;
    font-family:微软雅黑;
    color:white;
    border-radius:5px;
    outline:none;
    border:0px; 
    width: 40px; 
    height: 25px">
  &nbsp;&nbsp;
  <input type="button" onclick="deletes('teacher')" value="删除"
    style="background-color:#396ebe;
    font-size:15;
    font-family:微软雅黑;
    color:white;
    border-radius:5px;
    outline:none;
    border:0px; 
    width: 40px; 
    height: 25px"></th>
  <th>教师号</th>
  <th>姓名</th>
  <th>邮箱</th>
  <th>电话</th>
  </tr>
  <%
  ArrayList list=(ArrayList)session.getAttribute("pageList");
  if(list.isEmpty()){
   %>
   <tr>
   <td><span>暂无教师信息</span></td>
   </tr>
   <%
   }else{
   Teacher tea=new Teacher();
   for(int i=0;i<list.size();i++){
   tea=(Teacher)list.get(i);
    %>
   <tr>
   <td><input type="checkbox" name="teacher" value="<%=tea.getTeaId() %>"></td>
    <td><%=tea.getTeaId()  %></td>
    <td><%=tea.getUsername() %></td>
    <td><%=tea.getEmail()  %></td>
    <td><%=tea.getTel()  %></td>
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
            <a href="lookMessageAction.action?a=1">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="lookMessageAction.action?page=<s:property value="#request.pageBean.currentPage - 1"/>&a=1">上一页</a>&nbsp;&nbsp;&nbsp;<s:property value="#request.pageBean.currentPage"/>/<s:property value="#request.pageBean.totalPage"/>&nbsp;&nbsp;&nbsp;
        </s:else>
        
        <s:if test="#request.pageBean.currentPage != #request.pageBean.totalPage">
            <a href="lookMessageAction.action?page=<s:property value="#request.pageBean.currentPage + 1"/>&a=1">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a href="lookMessageAction.action?page=<s:property value="#request.pageBean.totalPage"/>&a=1">尾页</a>
        </s:if>
        
        <s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>
        <form action="lookMessageAction" onsubmit="return validate();">
            <input type="text" size="2" style="border-radius:5px; 
	        outline:none;
	        border:2px solid #666679; width: 40px; height: 20px"name="page">&nbsp;页
            <input type="hidden" name="a" value="1">
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
