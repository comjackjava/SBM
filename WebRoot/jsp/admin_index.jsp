<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>超市账单管理系统</title>
    
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
<frameset rows="100,*" cols="*" frameborder="no" border="0" framespacing="0">
	<frame src="jsp/admin_top.jsp" name="topFrame"  scrolling="No" noresize="noresize" id="topFrame" />
	<frameset cols="200,*" frameborder="no" border="0" framespacing="0">
		<frame src="jsp/admin_left.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" />
		<frame src="jsp/admin_bill_list.jsp" name="mainFrame" id="mainFrame" />
	</frameset>
</frameset>
<noframes><body>
</body></noframes>
</html>
