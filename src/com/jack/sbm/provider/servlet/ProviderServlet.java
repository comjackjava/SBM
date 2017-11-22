package com.jack.sbm.provider.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jack.sbm.common.bean.PageBean;
import com.jack.sbm.common.service.CommonService;
import com.jack.sbm.common.service.impl.CommonServiceImpl;
import com.jack.sbm.provider.bean.Provider;
import com.jack.sbm.provider.service.ProviderService;
import com.jack.sbm.provider.service.impl.ProviderServiceImpl;

public class ProviderServlet extends HttpServlet {
	private CommonService commonService=new CommonServiceImpl();
	private ProviderService providerService =new ProviderServiceImpl();
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
		String cmd = request.getParameter("cmd");
		System.out.println(cmd);
		switch (cmd) {
		case "getProvider":
			getProvider(request, response);
			break;
		case "getProviderCount":
			getProviderCount(request, response);
			break;
		case "updateProvider":
			updateProvider(request, response);
			break;
		case "addProvider":
			addProvider(request, response);
			break;
		default:
			break;
		}
		
	}

	private void addProvider(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String providerName =request.getParameter("providerName");
		String providerDetail =request.getParameter("providerDetail");
		String contact =request.getParameter("contact");
		String telephone =request.getParameter("telephone");
		String facsimile =request.getParameter("facsimile");
		String address =request.getParameter("address");
		Provider provider =new Provider(providerName, providerDetail, contact, telephone, facsimile, address);
		int row =providerService.addProvider(provider);
		if(row>0){
			response.sendRedirect("provider?cmd=getProviderCount");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新失败');</script>");
		}
		
	}

	private void updateProvider(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String providerId =request.getParameter("providerId");
		String providerName =request.getParameter("providerName");
		String providerDetail =request.getParameter("providerDetail");
		String contact =request.getParameter("contact");
		String telephone =request.getParameter("telephone");
		String facsimile =request.getParameter("facsimile");
		String address =request.getParameter("address");
		Provider provider =new Provider(Integer.parseInt(providerId), providerName, providerDetail, contact, telephone, facsimile, address);
		int row =providerService.updateProvider(provider);
		if(row>0){
			response.sendRedirect("provider?cmd=getProviderCount");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新失败');</script>");
		}
		
	}

	private void getProviderCount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("进入getProviderCount控制层");
		PageBean pageBean=new PageBean();
		String p =request.getParameter("p");
		String providerName =request.getParameter("providerName");
		String providerDetail =request.getParameter("providerDetail");
		System.out.println(p);
		if(p!=null&&!"".equals(p)){
			pageBean=(PageBean)commonService.getProviderCount(Integer.parseInt(p), providerName, providerDetail);
			request.getSession().setAttribute("pageBeanProvider", pageBean);
			request.getSession().setAttribute("providerName", providerName);
			request.getSession().setAttribute("providerDetail", providerDetail);
			PrintWriter out=response.getWriter();
			out.print("<script>location.href='jsp/providerAdmin.jsp'</script>");
		}else{
			pageBean=(PageBean)commonService.getProviderCount(1, providerName, providerDetail);
			request.getSession().setAttribute("pageBeanProvider", pageBean);
			request.getSession().setAttribute("providerName", providerName);
			request.getSession().setAttribute("providerDetail", providerDetail);
			PrintWriter out=response.getWriter();
			out.print("<script>location.href='jsp/providerAdmin.jsp'</script>");
		}
		
	}

	private void getProvider(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 ProviderService providerService=new ProviderServiceImpl();
		List<Provider> list =(List) providerService.getProvider();
		request.setAttribute("providers", list);
		//查询完所有的供应商之后再去进入到添加账单的页面
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/modify.jsp");
		requestDispatcher.forward(request, response);
	}

}
