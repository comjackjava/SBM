package com.jack.sbm.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jack.sbm.user.bean.User;
import com.jack.sbm.user.dao.UserDao;
import com.jack.sbm.utils.DBManager;

public class UserDaoImpl implements UserDao{
	private Connection con;
	private PreparedStatement ps;
	private User user=null;
	@Override
	public User doLogin(String userName, String userPassword) {
		// TODO Auto-generated method stub
		
		try {
			con=DBManager.getConnection();
			String sql ="select * from tb_user where userName=? and userPassword =?";
			ps=con.prepareStatement(sql);
			ps.setString(1,userName );
			ps.setString(2, userPassword);
			ResultSet rs =ps.executeQuery();
			if(rs.next()){
				user =new User(
						rs.getInt("userId"), 
						rs.getString("userName"), 
						rs.getString("userPassword"), 
						rs.getString("userSex"),
						rs.getInt("userAge"),
						rs.getString("telephone"),
						rs.getString("address"), 
						rs.getString("pic"), 
						rs.getInt("type")
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		
		return user;
	}

}
