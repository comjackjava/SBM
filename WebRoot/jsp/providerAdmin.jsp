<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'providerAdmin.jsp' starting page</title>
    
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
	function doit(flag, id) {
		if (flag == "del") {
			if (confirm("确认删除吗？") != true)
				return;
		}
		window.location = "provider.do?id=" + id + "&flag=" + flag;
	}
</script>
</head>
<body>
	<div class="menu">

		<table>
			<tbody>
				<tr>
					<td><form  id="formPagebean_top" method="post" >
							<input name="flag" value="search" type="hidden"> 供应商名称：<input
								name="providerName" value="${providerName}" class="input-text" type="text">
							&nbsp;&nbsp;&nbsp;&nbsp;供应商描述：<input value="${providerDetail}" name="providerDetail"
								class="input-text" type="text">&nbsp;&nbsp;&nbsp;&nbsp;<input
								 type="button" value="组 合 查 询" onclick="getPagebeanByP_bill()"  class="button">
						</form></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<em><input value="添加数据" class="input-button"
				onclick="window.location='providerAdd.jsp'" type="button"></em>
			<div class="title">供应商管理&gt;&gt;</div>
		</div>

		<div class="content">
			<table class="list">
				<tbody>
					<tr>
						<td width="70" height="29"><div class="STYLE1" align="center">编号</div></td>
						<td width="80"><div class="STYLE1" align="center">供应商名称</div></td>
						<td width="100"><div class="STYLE1" align="center">供应商描述</div></td>
						<td width="100"><div class="STYLE1" align="center">联系人</div></td>
						<td width="100"><div class="STYLE1" align="center">电话</div></td>
						<td width="100"><div class="STYLE1" align="center">传真</div></td>
						<td width="100"><div class="STYLE1" align="center">地址</div></td>
						<td width="100"><div class="STYLE1" align="center">操作</div></td>
					</tr>
					<c:forEach items="${pageBeanProvider.data}" var="providerCount">
					<tr>
						<td>${providerCount.providerId}</td>
						<td>${providerCount.providerName}</td>
						<td>${providerCount.providerDetail}</td>
						<td>${providerCount.contact}</td>
						<td>${providerCount.telephone}</td>
						<td>${providerCount.facsimile}</td>
						<td>${providerCount.address}</td>
						<td><a 
						href="jsp/updateProvider.jsp?
						providerId=${providerCount.providerId }&
						providerName=${providerCount.providerName}&
						providerDetail=${providerCount.providerDetail}&
						contact=${providerCount.contact}&
						telephone=${providerCount.telephone }&
						facsimile=${providerCount.facsimile }&
						address=${providerCount.address}&
						
						">修改</a></td>
					</tr>
					
					
					</c:forEach>
					
				</tbody>
			</table>
		</div>
	<label class="input-button">跳转到</label>
    		<select id="pSelect"  onchange="getPagebeanByP();">
    			<c:forEach var="i" begin="1" end="${pageBeanProvider.pageTotal }">
    				<c:if test="${pageBeanProvider.p == i }">
    					<option value="${i }" selected="selected">第${i }页</option>
    				</c:if>
    				<c:if test="${pageBeanProvider.p != i }">
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
		formPagebean.setAttribute("action","provider?cmd=getProviderCount&p="+${pageBeanProvider.p - 1 });
		formPagebean.submit();
	}
	function getPagebeanByP_down() {
		var formPagebean = document.getElementById("formPagebean_top");
		formPagebean.setAttribute("action","provider?cmd=getProviderCount&p="+${pageBeanProvider.p + 1 });
		formPagebean.submit();
	}
	function getPagebeanByP() {
		var formPagebean = document.getElementById("formPagebean_top");
		var p=document.getElementById("pSelect").value;
		formPagebean.setAttribute("action","provider?cmd=getProviderCount&p="+p);
		formPagebean.submit();
	}
	function getPagebeanByP_bill() {
		var formPagebean = document.getElementById("formPagebean_top");
		formPagebean.setAttribute("action","provider?cmd=getProviderCount&p=1");
		formPagebean.submit();
	}
</script>
</body></html>