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
    
    <title>My JSP 'admin_bill_list.jsp' starting page</title>
    
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
<body onload="fun()">

<div class="menu">
		<form id="formPagebean_top"  method="post" >
		商品名称：<input type="text" name="goodsName" value="${topInfo.goodsName }"  class="input-text" />&nbsp;&nbsp;&nbsp;&nbsp;
		是否付款：<select id="ops" name="isPayed" >
			 <option  value="2" >请选择</option>
		    <option value="1" >已付款</option>
		     <option value="0" >未付款</option>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" value="组合查询" onclick="getPagebeanByP_bill()" class="button"> 
		</form>
</div>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button"  onclick="location.href='../provider?cmd=getProvider'" /></em>
		<div class="title">账单管理&gt;&gt;</div>
	</div>
	<div class="content">
		<table class="list">
			<tr>
				<td>账单编号</td>
				<td>商品名称</td>
				<td>交易数量</td>
				<td>交易金额</td>
				<td>是否付款</td>
				<td>供应商名称</td>
				<td>商品描述</td>
				<td>账单时间</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${pageBeanAccount.data }" var="accountDetail">
					<tr>
						<td>${accountDetail.accountId }</td>
						<td>${accountDetail.goodsName }</td>
						<td>${accountDetail.businessNum }</td>
						<td>${accountDetail.totalPrice }</td>
						<td>
							<c:if test="${accountDetail.isPayed ==1 }">
							已付款
							</c:if>
							<c:if test="${accountDetail.isPayed ==0 }">
							未付款
							</c:if>
						</td>
						<td>${accountDetail.providerName }</td>
						<td>${accountDetail.goodsIntro }</td>
						<td>${accountDetail.accountDate }</td>
						<td><a href="jsp/updateAccount.jsp?accountId=${accountDetail.accountId }">修改</a></td>
					</tr>
				</c:forEach>
		</table>
	</div>

    		<label class="input-button">跳转到</label>
    		<select id="pSelect"  onchange="getPagebeanByP();">
    			<c:forEach var="i" begin="1" end="${pageBeanAccount.pageTotal }">
    				<c:if test="${pageBeanAccount.p == i }">
    					<option value="${i }" selected="selected">第${i }页</option>
    				</c:if>
    				<c:if test="${pageBeanAccount.p != i }">
    					<option value="${i }">第${i }页</option>
    				</c:if>
    			</c:forEach>
    		</select> 
    		<input type="button" class="input-button"  onclick="getPagebeanByP_up()" value="上一页" >
    		<input type="button" class="input-button"  onclick="getPagebeanByP_down()" value="下一页">
    	
    	
	</div>

</div>
	<input type="hidden" id="val" value="${topInfo.isPayed}">
	 <script type="text/javascript">
		function fun() {
			var val=document.getElementById("val").value;
			var ops=document.getElementById("ops");
			for(var i=0;i<ops.length;i++){
				if(ops.options[i].value==val){
					ops.options[i].setAttribute("selected","true");
				}
			}
			
			
		}
		function getPagebeanByP() {
			var formPagebean = document.getElementById("formPagebean_top");
			var p=document.getElementById("pSelect").value;
			formPagebean.setAttribute("action","account?cmd=getPagebeanByParam&p="+p);
			formPagebean.submit();
		}
		function getPagebeanByP_bill() {
			var formPagebean = document.getElementById("formPagebean_top");
			formPagebean.setAttribute("action","account?cmd=getPagebeanByParam&p=1");
			formPagebean.submit();
		}
		
		function getPagebeanByP_up() {
			var formPagebean = document.getElementById("formPagebean_top");
			formPagebean.setAttribute("action","account?cmd=getPagebeanByParam&p="+${pageBeanAccount.p - 1 });
			formPagebean.submit();
		}
		function getPagebeanByP_down() {
			var formPagebean = document.getElementById("formPagebean_top");
			formPagebean.setAttribute("action","account?cmd=getPagebeanByParam&p="+${pageBeanAccount.p + 1 });
			formPagebean.submit();
		}
		
	</script>
	
</body>
</html>
