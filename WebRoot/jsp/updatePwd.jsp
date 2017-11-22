
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
    
    <title>My JSP 'updatePwd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
  function checkit() {
	 var old=document.getElementById("old").value;
	 var pwd=document.getElementById("userPassword").value;
	 var pwd2=document.getElementById("userPassword2").value;
	 if(old!=${pwd} ){
		 alert("原密码错误");
		 return false;
	 }else{
		 if(pwd!=pwd2){
			 alert("两次新密码不一致");
			 return false;
		 }else{
			 return true;
		 }
	 }
	

}
  </script>
  </head>
  <body>
   <div class="title">修改密码&gt;&gt;</div>
   <form method="post" action="user?cmd=updatePwd"  onsubmit="return checkit();"><br>
   原密码<input type="text" name="oldPwd"   id="old"><br>
  新密码<input type="text" name="userPassword" id="userPassword"><br>
   再次输入新密码<input type="text" name="userPassword2" id="userPassword2"><br>
  <div class="buttons">
				<input type="submit" name="button" id="button" value="数据提交"
					class="input-button" /> <input type="button" name="button"
					id="button" onclick="history.back();" value="返回"
					class="input-button" />
 </div>
   </form>
  </body>
</html>
