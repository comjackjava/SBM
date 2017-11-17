package com.jack.sbm.common.listener;


import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.jack.sbm.user.bean.User;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("SessionListener监听器被创建");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		HttpSession session=arg0.getSession();
		ServletContext application=session.getServletContext();
		User user=(User)session.getAttribute("user");//退出者的用户名
		//获取在线用户集合
		List online=(List)application.getAttribute("online");
		online.remove(user);//从在线用户集合中删除
		application.setAttribute("online", online);
		System.out.println("SessionListener监听器被销毁");
	}

}
