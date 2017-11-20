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
    
    <title>My JSP 'admin_left.jsp' starting page</title>
    
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
<body class="frame-bd">
<ul class="left-menu">
	<li><a href="jsp/admin_bill_list.jsp" target="mainFrame"><img src=""><img src="jsp/images/btn_bill.gif" /></a></li>
    <c:if test="${user.type==0}">
    	<li><a href="jsp/providerAdmin.jsp" target="mainFrame"><img src="jsp/images/btn_suppliers.gif" /></a></li>
		<li><a href="user?cmd=getUserCount" target="mainFrame"><img src="jsp/images/btn_users.gif" /></a></li>
    </c:if>
	<li><a href="user?cmd=userexit" onClick="javaScript:alert('这里实现退出操作！')"><img src="jsp/images/btn_exit.gif" /></a></li>
</ul>
</body>
</html>
