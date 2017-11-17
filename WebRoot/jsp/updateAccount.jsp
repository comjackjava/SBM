<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateAccount.jsp' starting page</title>
    
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
    <div class="menu">
	</div>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">账单管理&gt;&gt;</div>
		</div>
		<form method="post" action="account?cmd=updateAccount">
			<div class="content">
				<table class="box">
					<tr>
						<td class="field">账单编号：</td>
						<td><input readonly="readonly" type="text" name="accountId" class="text" value="${param.accountId}" /></td>
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
				<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
				<input type="submit" name="submit" value="修改" class="input-button" />
				<a style="text-decoration: none;" class="input-button" href="account?cmd=deleteAccount&&accountId=${param.accountId}" >删除</a>
			</div>
		</form>
	</div>
  </body>
</html>
