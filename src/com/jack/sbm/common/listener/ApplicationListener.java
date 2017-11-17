package com.jack.sbm.common.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.jack.sbm.user.bean.User;

public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("application监听器销毁成功！");
		
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("application监听器初始化成功！");
		ServletContext application =arg0.getServletContext();
		List<User> online =new ArrayList<>();
		application.setAttribute("online", online);
		
	}

}
