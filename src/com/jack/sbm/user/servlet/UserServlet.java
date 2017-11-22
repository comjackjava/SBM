package com.jack.sbm.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.SetAllPropertiesRule;
import org.apache.tomcat.jni.File;

import com.jack.sbm.common.bean.PageBean;
import com.jack.sbm.common.dao.impl.CommonDaoImpl;
import com.jack.sbm.common.service.CommonService;
import com.jack.sbm.common.service.impl.CommonServiceImpl;
import com.jack.sbm.provider.service.ProviderService;
import com.jack.sbm.user.bean.User;
import com.jack.sbm.user.service.UserService;
import com.jack.sbm.user.service.impl.UserServiceImpl;
import com.jack.sbm.utils.Constant;
import com.jack.sbm.utils.IDUtil;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class UserServlet extends HttpServlet {
private UserService userService=new UserServiceImpl();
private CommonService commonService=new CommonServiceImpl();
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
		case "updatePwd":
			updatePwd(request,response);
			break;
		case "uploadPic":
			uploadPic(request, response);
			break;
		case "addUser":
			addUser(request, response);
			break;
		case "getUser":
			getUser(request, response);
			break;
		case "updateUser":
			updateUser(request, response);
			break;
		case "deleteUser":
			deleteUser(request, response);
			break;
		case "getUserCount":
			getUserCount(request, response);
			break;
		default:
			break;
		}
		
	}

	private void updatePwd(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String pwd=request.getParameter("userPassword");
		int userId=(int) request.getSession().getAttribute("userId");
		int row =userService.updatePwd(userId, pwd);
		if(row>0){
			request.getSession().invalidate();
			String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
			PrintWriter out=response.getWriter();
			out.print("<script>window.top.location.href='"+basePath+"'</script>");
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新失败');</script>");
		}
		
	}

	private void getUserCount(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PageBean pageBean =new PageBean(); 
		String p=request.getParameter("p");
		String userName=request.getParameter("userName");
		if(p!=null&&!"".equals(p)){
			pageBean=(PageBean)commonService.getUserCount(Integer.parseInt(p), userName);
			request.getSession().setAttribute("pageBean", pageBean);
			request.getSession().setAttribute("userName", userName);
			PrintWriter out=response.getWriter();
			out.print("<script>location.href='jsp/userAdmin.jsp'</script>");
		}else{
			pageBean=(PageBean)commonService.getUserCount(1, userName);
			request.getSession().setAttribute("pageBean", pageBean);
			request.getSession().setAttribute("userName", userName);
			PrintWriter out=response.getWriter();
			out.print("<script>location.href='jsp/userAdmin.jsp'</script>");
		}
	}

	private void deleteUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
String userId = request.getParameter("userId");
		
		int row = userService.deleteUserById(Integer.parseInt(userId));
		if(row > 0){
			//删除成功
			response.sendRedirect("user?cmd=getUserCount");
		}else{
			//删除失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除失败');</script>");
		}
		
	}

	private void updateUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String userId =request.getParameter("userId");
		String userName =request.getParameter("userName");
		String userPassword =request.getParameter("userPassword");
		String userSex =request.getParameter("userSex");
		String userAge =request.getParameter("userAge");
		String telephone =request.getParameter("telephone");
		String address =request.getParameter("address");
		String type =request.getParameter("type");
		
		int row = userService.updateUser(
			    Integer.parseInt(userId),
				userName, 
				userSex, 
				userPassword,
				address, 
				Integer.parseInt(userAge), 
				telephone, 
				Integer.parseInt(type));
		
		if(row > 0){
			//修改成功
			response.sendRedirect("user?cmd=getUserCount");
		}else{
			//修改失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新失败');</script>");
		}
		
	}

	private void getUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		List<User> list =new ArrayList<>();
		list=(List<User>)userService.getUser();
		request.getSession().setAttribute("getusers", list);
		response.sendRedirect("jsp/userAdmin.jsp");
	}

	private void addUser(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String userName = (String)request.getAttribute("userName");
		String userPassword = (String)request.getAttribute("userPassword");
		String userSex = (String)request.getAttribute("userSex");
		String userAge = (String)request.getAttribute("userAge");
		String telephone = (String)request.getAttribute("telephone");
		String address = (String)request.getAttribute("address");
		String type = (String)request.getAttribute("type");
		
		String pic = (String) request.getAttribute("pic");
		
		User user = new User(
				userName, 
				userPassword,
				userSex,
				Integer.parseInt(userAge),
				telephone, 
				address, 
				pic,
				Integer.parseInt(type));
		
		int row = userService.addUser(user);
		PrintWriter out = response.getWriter();
		if(row > 0){
			//添加成功:重新查询添加后的用户列表，然后进入到用户列表分页页面
//			out.print("<script>alert('添加用户成功!');</script>");
			
			response.sendRedirect("user?cmd=getUserCount");
		}else{
			//添加失败
			out.print("<script>alert('添加用户失败!');</script>");
		}
	}

	private void uploadPic(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(getServletConfig(), request, response);
		smartUpload.setAllowedFilesList("png,jpg,jpeg,gif");
		smartUpload.setMaxFileSize(1024*1024*5);
		try {
			//上传文件
			smartUpload.upload();
			//samrtuoload组件提供的请求对象，表单的参数都在这个request对象中存取的，而不在jsp内置对象request中了
			Request sRequest = smartUpload.getRequest();
			//获取要上传文件的对象
			com.jspsmart.upload.File file = smartUpload.getFiles().getFile(0);
			//保存文件,确保文件无中文，唯一性
			//12306:100w/1000=1000:
			//uuid的文件名
			//图片名称
			String picName = IDUtil.getUUID();
			//图片保存的相对文件夹路径
			String picFilePath = Constant.FILE_USER_PHOTO_PATH;
			java.io.File filePath = new java.io.File(request.getRealPath("/")+picFilePath);
			if(!filePath.exists()){
				filePath.mkdirs();
			}
			//文件的后缀名
			String extName = file.getFileExt();
			//图片的文件相对路径(存在数据库的路径)
			String picPath = picFilePath + picName + "." +extName;
			//保存路径
			String savePath = request.getRealPath("/") + picPath;
			//另存为（可以修改名字）
			file.saveAs(savePath);
			//如果保存成功了将继续往下执行，然后添加用户数据，因为需要使用原请求的用户参数，所以必须使用请求转发
			request.setAttribute("userName", sRequest.getParameter("userName"));
			request.setAttribute("userPassword", sRequest.getParameter("userPassword"));
			request.setAttribute("userSex", sRequest.getParameter("userSex"));
			request.setAttribute("userAge", sRequest.getParameter("userAge"));
			request.setAttribute("telephone", sRequest.getParameter("telephone"));
			request.setAttribute("address", sRequest.getParameter("address"));
			request.setAttribute("type", sRequest.getParameter("type"));
			request.setAttribute("pic", picPath);//第2步得到的图片保存的相对路径，需要存在数据库中
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("user?cmd=addUser");
			requestDispatcher.forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			request.getSession().setAttribute("pwd", userPassword);
			request.getSession().setAttribute("userId",user.getUserId());
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
