<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>" target="main">
    
    <title>menu</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <script type="text/javascript">
 function FOLDMenu(id,onlyone){
  if(!document.getElementById || !document.getElementsByTagName){return false;}
  this.menu=document.getElementById(id);
  this.submenu=this.menu.getElementsByTagName("ul");
  this.speed=3;
  this.time=10;
  this.onlyone=onlyone==true?onlyone:false;
  this.links = this.menu.getElementsByTagName("a");
 }
 FOLDMenu.prototype.init=function(){
  var mainInstance = this;
  for(var i=0;i<this.submenu.length;i++){
   this.submenu[i].getElementsByTagName("span")[0].onclick=function(){
    mainInstance.toogleMenu(this.parentNode);
   };
  }
  for(var i=0;i<this.links.length;i++){
   this.links[i].onclick=function(){
    this.className = "current";
    mainInstance.removeCurrent(this);
   }
  }
 }
 FOLDMenu.prototype.removeCurrent = function(link){
   for (var i = 0; i < this.links.length; i++){
    if (this.links[i] != link){
     this.links[i].className = " "; 
    }
   }
 }
 FOLDMenu.prototype.toogleMenu=function(submenu){
  if(submenu.className=="open"){
   this.closeMenu(submenu);
  }else{
   this.openMenu(submenu);
  }
 }
 FOLDMenu.prototype.openMenu=function(submenu){
  var fullHeight=submenu.getElementsByTagName("span")[0].offsetHeight;
  var links = submenu.getElementsByTagName("a");
  for (var i = 0; i < links.length; i++){
   fullHeight += links[i].offsetHeight;
  }
   var moveBy = Math.round(this.speed * links.length); 
   var mainInstance = this; 
    var intId = setInterval(function() { 
     var curHeight = submenu.offsetHeight; 
     var newHeight = curHeight + moveBy; 
     if (newHeight <fullHeight){
      submenu.style.height = newHeight + "px";
     }else {
      clearInterval(intId);
      submenu.style.height = ""; 
      submenu.className = "open";
     } 
    }, this.time); 
    this.collapseOthers(submenu);
 }
 FOLDMenu.prototype.closeMenu=function(submenu){
   var minHeight=submenu.getElementsByTagName("span")[0].offsetHeight;
   var moveBy = Math.round(this.speed * submenu.getElementsByTagName("a").length);
   var mainInstance = this;
    var intId = setInterval(function() {
     var curHeight = submenu.offsetHeight;
     var newHeight = curHeight - moveBy;
     if (newHeight > minHeight){
      submenu.style.height = newHeight + "px";
     }else {
      clearInterval(intId);
      submenu.style.height = ""; 
      submenu.className = "";
     } 
    }, this.time); 
 }
 FOLDMenu.prototype.collapseOthers = function(submenu){
  if(this.onlyone){
   for (var i = 0; i < this.submenu.length; i++){
    if (this.submenu[i] != submenu){
     this.closeMenu(this.submenu[i]); 
    }
   }
  }
 }
</script>
<style type="text/css">
*{margin:0;padding:0;}
.foldmenu{border:1px solid #000000;width:150px;margin:50px;}
.foldmenu ul{list-style-type:none;height:25px;line-height:25px;overflow:hidden;cursor:pointer;}
.foldmenu ul.open{height:auto;color: #343345;outline:none;
	border:0px;}
.foldmenu ul span{display:block;padding-left:5px;font-size:20px;color:white }
.foldmenu ul li{border-bottom:1px solid white;}
.foldmenu li a{outline:none;border:0px;border:0px solid #000000;background-color:#343345;color:white;display:block;padding:5px 10px;text-decoration:none;text-align:center;}
.foldmenu li a:hover{background-color:#396ebe;color:#343345;}
.foldmenu li a.current{background-color:#343345;color:white;}
</style>
</head>
<body style="background: url('images/左.png') repeat 0px 0px;background-size: cover;">
<div id="foldmenu" class="foldmenu" style="float:left;margin-left:20;outline:none;border:0px;">
 <ul class="open">
  <span>学生管理</span>
 <li><a href="lookMessageAction?a=0">查看学生</a></li>
 <li><a href="<%=request.getContextPath()%>/upload/upload.jsp">导入学生</a></li>
  <li><a href="<%=request.getContextPath()%>/admin/addStudent.jsp">添加学生</a></li>
 <li><a href="<%=request.getContextPath()%>/admin/findStudent.jsp">修改学生</a></li>
 </ul>
 <ul>
  <span>教师管理</span>
 <li><a href="lookMessageAction?a=1">查看教师</a></li>
 <li><a href="<%=request.getContextPath()%>/admin/addTeacher.jsp">添加教师</a></li>
 <li><a href="<%=request.getContextPath()%>/admin/findTeacher.jsp">修改教师</a></li>
 </ul>
 <ul>
  <span>课程管理</span>
 <li><a href="<%=request.getContextPath()%>/admin/ERROR.jsp">查看课程</a></li>
  <li><a href="<%=request.getContextPath()%>/admin/ERROR.jsp">添加课程</a></li>
  <li><a href="<%=request.getContextPath()%>/admin/ERROR.jsp">修改课程</a></li>
 </ul>
  <ul>
  <span>信息管理</span>
 <li><a href="<%=request.getContextPath()%>/admin/ERROR.jsp">查看个人信息</a></li>
  <li><a href="<%=request.getContextPath()%>/password/changePwd.jsp">修改密码</a></li>
 </ul>
</div>
<script type="text/javascript">
window.onload = function() {
 myMenu = new FOLDMenu("foldmenu",true);
 myMenu.init();
 myMenu2 = new FOLDMenu("foldmenu2");
 myMenu2.init();
};
</script>
</body>
</html>