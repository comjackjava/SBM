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
    
    <title>My JSP 'modify.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<link type="text/css" rel="stylesheet" href="jsp/css/style.css" />
</head>
<body>
		<div class="menu">
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<form method="post" action="goods?cmd=getGoodsInfoByName">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">商品名称：</td>
						<td><input type="text" name="goodsName" class="text" /></td>
					</tr>
					<tr>
						<td class="field">交易数量：</td>
						<td><input type="text" name="businessNum" class="text" /></td>
					</tr>
					<tr>
						<td class="field">供应商：</td>
						<td>
							<select name="providerId">
								<c:forEach items="${providers}" var="pro">
									<option value="${pro.providerId }">${pro.providerName }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td class="field">是否付款：</td>
						<td>
							<select name="isPayed">
								<option selected="selected" value="1">是</option>
								<option value="0">否</option>
							</select>
						</td>
					</tr>
				</table>
			</div>
			<div class="buttons">
				<input type="submit" name="submit" value="确认" class="input-button" />
				<input type="button" name="button" value="返回" class="input-button"
					onclick="history.back();" />
			</div>
		</form>
	</div>
</body>
</html>
