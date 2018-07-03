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
    alert("你确定要删除这些学生:"+bb+"吗?");
    location.href="deleteStudentAction?deleteStudentValue="+bb;
    }
    </script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="pink">
  <center>
  <s:div>
  <hr color="red">
  <br>
  <hr color="red">
  <br><br><br>
  </s:div>
  <table width="80%" border="5">
  <tr>
  <th><input type="button" onclick="checkboxed('student')" value="全选"><input type="button" onclick="deletes('student')" value="删除"></th>
  <th>学号</th>
  <th>姓名</th>
  <th>性别</th>
  <th>院系</th>
  <th>籍贯</th>
  <th>邮箱</th>
  <th>电话</th>
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
   Student stu=new Student();
   for(int i=0;i<list.size();i++){
   stu=(Student)list.get(i);
    %>
   <tr>
   <td><input type="checkbox" name="student" value="<%=stu.getStuId() %>"></td>
    <td><%=stu.getStuId() %></td>
    <td><%=stu.getUsername() %></td>
    <td><%=stu.getSex() %></td>
    <td><%=stu.getDepartment() %></td>
    <td><%=stu.getJiguan() %></td>
    <td><%=stu.getEmail() %></td>
    <td><%=stu.getTel() %></td>
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
            <input type="text" size="2" name="page">页
            <input type="hidden" name="a" value="0">
            <input type="submit" value="跳转">
        </form>
  </center>
  </body>
</html>
