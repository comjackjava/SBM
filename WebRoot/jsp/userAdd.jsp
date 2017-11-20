<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userAdd.jsp' starting page</title>
    
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
	function checkit() {
		//判断是否是数字的正则表达式
		if(
			checkEmpty("userName") &&
			checkEmpty("userPassword") &&
			checkEmpty("userPassword1") &&
			checkEmpty("userSex") &&
			checkEmpty("userAge") &&
			checkEmpty("telephone") &&
			checkEmpty("address") &&
			checkEmpty("pic") &&
			checkEmpty("type")
		){
			//非空验证通过
			if(checkPassword()){
				//密码验证通过
				if(checkAge()){
					//年龄验证通过
					return true;//提交表单数据
				}else{
					alert("年龄只能在0-120之间!");
					return false;
				}
			}else{
				//密码验证不通过
				alert("密码不一致!");
				return false;
			}
			
		}else{
			//非空验证不通过
			alert("请检查用户信息是否完整!");
			return false;
		}
	}
	
	function checkAge() {
		var userAge = document.getElementById("userAge").value;
		if(userAge > 0 && userAge < 120){
			//满足数据要求
			return true;
		}else{
			return false;
		}
	}
	
	function checkEmpty(id) {
		var suiyi = document.getElementById(id).value;
		if(suiyi != null && suiyi != ""){
			return true;
		}else{
			return false;
		}
	}
	
	function checkPassword() {
		var userPassword = document.getElementById("userPassword").value;
		var userPassword1 = document.getElementById("userPassword1").value;
		if(userPassword == userPassword1){
			return true;
		}else{
			return false;
		}
	}
</script>
</head>
<body>
	<div class="main">
		<div class="optitle clearfix">
			<div class="title">用户管理&gt;&gt;</div>

		</div>
		<form method="post" action="user?cmd=uploadPic" enctype="multipart/form-data" onsubmit="return checkit();">
			<div class="content">
				<table class="box">
					
					<tr>
						<td class="field">用户名称：</td>
						<td><input type="text" name="userName" class="text"
							id="userName" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">用户密码：</td>

						<td><input type="password" name="userPassword" class="text"
							id="userPassword" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">确认密码：</td>
						<td><input type="password" id="userPassword1" name="userPassword1" class="text" /> <font
							color="red">*</font></td>
					</tr>

					<tr>
						<td class="field">用户性别：</td>
						<td>
							<select name="userSex" id="userSex">
								<option selected="selected" value="0">女</option>
								<option value="1">男</option>
							</select>
						<font color="red">*</font>
						</td>
					</tr>

					<tr>
						<td class="field">用户年龄：</td>
						<td><input type="text" name="userAge" class="text"
							id="userAge" /> <font color="red">*</font></td>
					</tr>
					<tr>
						<td class="field">用户电话：</td>
						<td><input type="text" name="telephone" class="text"
							id="telephone" /> <font color="red">*</font></td>

					</tr>
					<tr>
						<td class="field">用户地址：</td>
						<td><textarea name="address" id="address" class="text"
								cols="45" rows="5"></textarea>
							<font color="red">*</font>		
						</td>
					</tr>
					<tr>
						<td class="field">用户权限：</td>

						<td>
							<input type="radio" name="type" id="type" value="1" checked="checked" />普通用户 
							<input type="radio" name="type" id="type" value="0" />经理
							<font color="red">*</font>
						</td>
					</tr>
					<tr>
						<td class="field">用户头像：</td>
						<td>
							<input type="file" id="pic" name="pic" class="text">
							<font color="red">*只允许png,jpg,jpeg,gif类型的文件最大文件大小为5M</font>
						</td>
					</tr>
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
