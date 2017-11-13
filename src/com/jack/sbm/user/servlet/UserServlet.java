package com.jack.sbm.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jack.sbm.user.bean.User;
import com.jack.sbm.user.service.UserService;
import com.jack.sbm.user.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
private UserService userService =new UserServiceImpl();
private User user=null;
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

		default:
			break;
		}
		
	}

	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("进入dologin方法");
		String userName =request.getParameter("userName");
		String userPassword=request.getParameter("userPassword");
		user=userService.doLogin(userName, userPassword);
		request.getSession().setAttribute("user", user);
		if(user!=null){
			response.sendRedirect("jsp/admin_index.jsp");
		}else{
			response.sendRedirect("index.jsp?loginMsg=failed");
		}
		
	}

}
