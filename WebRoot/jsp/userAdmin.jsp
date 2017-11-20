<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userAdmin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

 <link type="text/css" rel="stylesheet" href="jsp/css/style.css">
<script type="text/javascript">
function doit(flag,id)
{
	if(flag=="del")
	{
		if(confirm("确认删除吗？")!=true)
			return;
	}
	
}
</script>
</head><body>




<div class="menu">

<table>
<tbody><tr><td>
<form method="post"  id="formPagebean_top">
<input name="flag" value="search" class="input-text" type="hidden">
用户名称：<input name="userName" value="${userName}" class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp; <input class="button" value="查 询" onclick="getPagebeanByP_bill()" type="button">
</form></td></tr>
</tbody></table>
</div>
<div class="main">

<div class="optitle clearfix">
<em><input value="添加数据" class="input-button" onclick="window.location='userAdd.jsp'" type="button"></em>
		<div class="title">用户管理&gt;&gt;</div>
	</div>
	<div class="content">
<table class="list">
  <tbody><tr>
    <td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
    <td width="80"><div class="STYLE1" align="center">用户名称</div></td>
    <td width="100"><div class="STYLE1" align="center">性别</div></td>
    <td width="100"><div class="STYLE1" align="center">年龄</div></td>

    <td width="150"><div class="STYLE1" align="center">电话 </div></td>
    <td width="150"><div class="STYLE1" align="center">地址 </div></td>
    <td width="150"><div class="STYLE1" align="center">权限 </div></td>
    <td width="150"><div class="STYLE1" align="center">操作 </div></td>
  </tr>
  
  <c:forEach items="${pageBean.data}" var="user">
					<tr>
						<td>${user.userId }</td>
						<td>${user.userName }</td>
						<td>${user.userSex }</td>
						<td>${user.userAge }</td>
						<td>${user.telephone }</td>
						<td>${user.address }</td>
							<td>
							<c:if test="${user.type ==1 }">
							普通用户
							</c:if>
							<c:if test="${user.type ==0 }">
							经理
							</c:if>
						</td>
						<td><a 
						href="jsp/updateUser.jsp?
						userId=${user.userId }&
						userName=${user.userName}&
						userSex=${user.userSex }&
						userAge=${user.userAge }&
						telephone=${user.telephone }&
						address=${user.address}&
						userPassword=${user.userPassword}
						">修改</a></td>
					</tr>
				</c:forEach>
</tbody></table>
</div>
<label class="input-button">跳转到</label>
    		<select id="pSelect"  onchange="getPagebeanByP();">
    			<c:forEach var="i" begin="1" end="${pageBean.pageTotal }">
    				<c:if test="${pageBean.p == i }">
    					<option value="${i }" selected="selected">第${i }页</option>
    				</c:if>
    				<c:if test="${pageBean.p != i }">
    					<option value="${i }">第${i }页</option>
    				</c:if>
    			</c:forEach>
    		</select> 
    		<input type="button" class="input-button"  onclick="getPagebeanByP_up()" value="上一页" >
    		<input type="button" class="input-button"  onclick="getPagebeanByP_down()" value="下一页">
</div>
<script type="text/javascript">
	function getPagebeanByP_up() {
		var formPagebean = document.getElementById("formPagebean_top");
		formPagebean.setAttribute("action","user?cmd=getUserCount&p="+${pageBean.p - 1 });
		formPagebean.submit();
	}
	function getPagebeanByP_down() {
		var formPagebean = document.getElementById("formPagebean_top");
		formPagebean.setAttribute("action","user?cmd=getUserCount&p="+${pageBean.p + 1 });
		formPagebean.submit();
	}
	function getPagebeanByP() {
		var formPagebean = document.getElementById("formPagebean_top");
		var p=document.getElementById("pSelect").value;
		formPagebean.setAttribute("action","user?cmd=getUserCount&p="+p);
		formPagebean.submit();
	}
	function getPagebeanByP_bill() {
		var formPagebean = document.getElementById("formPagebean_top");
		formPagebean.setAttribute("action","user?cmd=getUserCount&p=1");
		formPagebean.submit();
	}
</script>
</body></html>