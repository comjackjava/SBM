package com.jack.sbm.user.dao;

import java.util.List;

import com.jack.sbm.user.bean.User;

public interface UserDao {
	public User doLogin(String userName ,String userPassword);
	public int addUser(User user);
	public List<User> getUser();
	public int deleteUserById(int userId);
	public int updateUser(int userId,String userName,String userSex,String userPassword,String address,int userAge,String telephone,int type);
}
