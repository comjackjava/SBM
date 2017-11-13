package com.jack.sbm.user.dao;

import com.jack.sbm.user.bean.User;

public interface UserDao {
	public User doLogin(String userName ,String userPassword);
}
