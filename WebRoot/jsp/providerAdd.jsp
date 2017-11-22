<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'providerAdd.jsp' starting page</title>
    
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
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">供应商管理&gt;&gt;</div>
		</div>
		<form id="form1" name="form1" method="post" action="provider?cmd=addProvider"
			onsubmit="return checkit();">
			<div class="content">
				<font color="red"></font> <input name="flag" value="doAdd"
					type="hidden">
				<table class="box">

					<tbody>
						<tr>
							<td class="field">供应商编号：</td>
							<td><input name="providerId" id="textfield" class="text"
								type="text"> <font color="red">*</font></td>
						</tr>
						<tr>
							<td class="field">供应商名称：</td>
							<td><input name="providerName" id="textfield2" value=""
								class="text" type="text"> <font color="red">*</font></td>

						</tr>
						<tr>
							<td class="field">供应商描述：</td>
							<td><textarea name="providerDetail" id="textarea" cols="45"
									rows="5"></textarea></td>
						</tr>
						<tr>
							<td class="field">供应商联系：</td>

							<td><input name="contact" id="textfield2" value=""
								class="text" type="text"></td>
						</tr>
						<tr>
							<td class="field">供应商电话：</td>
							<td><input name="telephone" id="textfield2" value=""
								class="text" type="text"></td>
						</tr>
						<tr>
							<td class="field">供应商传真：</td>

							<td><input name="facsimile" id="textfield2" value="" class="text"
								type="text"></td>
						</tr>
						<tr>
							<td class="field">供应商地址：</td>
							<td><input name="address" id="textfield2" value=""
								class="text" type="text"></td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="buttons">
				<input type="submit" name="button" id="button" value="数据提交"
					class="input-button" /> <input type="button" name="button"
					id="button" onclick="history.back();" value="返回"
					class="input-button" />
			</div>
		</form>
	</div>
</body>
</html>
