package com.jack.sbm.account.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jack.sbm.account.service.AccountService;
import com.jack.sbm.account.service.impl.AccountServiceImpl;
import com.jack.sbm.common.bean.PageBean;
import com.jack.sbm.common.bean.TopInfo;
import com.jack.sbm.common.service.CommonService;
import com.jack.sbm.common.service.impl.CommonServiceImpl;
import com.jack.sbm.goods.bean.Goods;




public class AccountServlet extends HttpServlet {
private AccountService accountService=new AccountServiceImpl();
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cmd =request.getParameter("cmd");
		switch (cmd) {
		case "getPagebeanByParam":
			getPagebeanByParam(request,response);
			break;
		case "addAccount":
			addAccount(request, response);
			break;
		case "updateAccount":
			updateAccount(request, response);
			break;
		case "deleteAccount":
			deleteAccount(request, response);
			break;

		default:
			break;
		}
	}

	private void deleteAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String accountId = request.getParameter("accountId");
		
		int row = accountService.deleteAccountById(Integer.parseInt(accountId));
		if(row > 0){
			//删除成功
			response.sendRedirect("account?cmd=getPagebeanByParam&&p=1");
		}else{
			//删除失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除失败');</script>");
		}
	}

	private void updateAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String accountId = request.getParameter("accountId");
		String isPayed = request.getParameter("isPayed");
		
		
		int row = accountService.updateAccount(Integer.parseInt(accountId), Integer.parseInt(isPayed));
		
		if(row > 0){
			//修改成功
			response.sendRedirect("account?cmd=getPagebeanByParam&&p=1");
		}else{
			//修改失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新失败');</script>");
		}
	}

	private void addAccount(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String providerId = request.getParameter("providerId");
		String isPayed = request.getParameter("isPayed");
		String businessNum = request.getParameter("businessNum");
		
		Goods goods = (Goods) request.getAttribute("goods");
		
		int row = accountService.addAccount(
						goods, 
						Integer.parseInt(providerId), 
						Integer.parseInt(isPayed), 
						Integer.parseInt(businessNum));
		
		if(row > 0){
			//添加成功
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("goods?cmd=updateGoods");
			requestDispatcher.forward(request, response);
		}else{
			//添加失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('添加失败');</script>");
		}
	}

	private void getPagebeanByParam(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PageBean pageBean =new PageBean();
		
		CommonService commonService =new CommonServiceImpl();
		String p =request.getParameter("p");
		String isPayed=request.getParameter("isPayed");
		String  goodsName=request.getParameter("goodsName");
		
		if(p != null && p != ""){
		TopInfo topInfo =new TopInfo(goodsName, isPayed);
		 pageBean =(PageBean)commonService.getCount(Integer.parseInt(p), isPayed, goodsName);
		 request.getSession().setAttribute("pageBeanAccount", pageBean);
		 request.getSession().setAttribute("topInfo", topInfo);
		 
		PrintWriter out=response.getWriter();
		out.print("<script>location.href='jsp/admin_bill_list.jsp'</script>");
		}else{
			TopInfo topInfo =new TopInfo(goodsName, "2");
			pageBean =(PageBean)commonService.getCount(1, "2", goodsName);
			request.getSession().setAttribute("pageBeanAccount", pageBean);
			 request.getSession().setAttribute("topInfo", topInfo);
			response.sendRedirect("jsp/admin_index.jsp");
		}
	
		
	}

}
