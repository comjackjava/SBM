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
    
    <title>My JSP 'admin_top.jsp' starting page</title>
    
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
<div id="header">
	<div class="title"></div>
	<div class="welcome">欢迎您：${user.userName}
	&emsp;&emsp;&emsp;&emsp;&emsp;
	<a href="jsp/updatePwd.jsp" target="mainFrame">修改密码</a>
	
	&emsp;&emsp;&emsp;&emsp;&emsp;
	<label>在线人数：${online.size()}</label>
	</div>
</div>
</body>
</html>
