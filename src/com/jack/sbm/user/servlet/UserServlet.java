package com.jack.sbm.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;


import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jack.sbm.user.bean.User;
import com.jack.sbm.user.service.UserService;
import com.jack.sbm.user.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
private Connection con;
private UserService userService=new UserServiceImpl();
private User user=null;
private Boolean login=false;

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

		String cmd=request.getParameter("cmd");
		System.out.println(cmd);
		switch (cmd) {
		case "userlogin":
			doLogin(request,response);
			break;
		case "userexit":
			doExit(request,response);
			break;

		default:
			break;
		}
		
	}

	private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.getSession().invalidate();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		PrintWriter out=response.getWriter();
		out.print("<script>window.top.location.href='"+basePath+"'</script>");
	}

	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("进入dologin方法");
		String userName =request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		user=userService.doLogin(userName, userPassword);
		
		if(user!=null){
			request.getSession().setAttribute("user", user);
			List<User>  online =(List<User>)request.getServletContext().getAttribute("online");
			for (User userOnline : online) {
				if(userOnline.getUserId()==user.getUserId()){
					login=true;
				}
			}
			if(!login){
				online.add(user);
				request.getServletContext().setAttribute("online", online);
			}
			response.sendRedirect("account?cmd=getPagebeanByParam");
		}else{
			response.sendRedirect("index.jsp?loginMsg=failed");
		}
		
	}

}
