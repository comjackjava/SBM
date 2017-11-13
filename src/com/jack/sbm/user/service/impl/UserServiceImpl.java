package com.jack.sbm.user.service.impl;

import com.jack.sbm.user.bean.User;
import com.jack.sbm.user.dao.impl.UserDaoImpl;
import com.jack.sbm.user.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User doLogin(String userName, String userPassword) {
		// TODO Auto-generated method stub
		
		return new UserDaoImpl().doLogin(userName, userPassword);
	}

}
