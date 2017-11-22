package com.jack.sbm.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		
		con = DBManager.getConnection();
		String sql = "select * from tb_user where userName = ? and userPassword = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userPassword);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				user =new User(
						rs.getInt("userId"),
						rs.getString("userName"),
						userPassword, 
						rs.getString("userSex"),
						rs.getInt("userAge"),
						rs.getString("telephone"),
						rs.getString("address"), 
						rs.getString("pic"),
						rs.getInt("type"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		return user;
	}
	@Override
	public int addUser(User user) {
		con = DBManager.getConnection();
		String sql = "insert into tb_user values (?,?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPassword());
			ps.setString(3, user.getUserSex());
			ps.setInt(4, user.getUserAge());
			ps.setString(5, user.getTelephone());
			ps.setString(6, user.getAddress());
			ps.setString(7, user.getPic());
			ps.setInt(8, user.getType());

			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public List<User> getUser() {
		// TODO Auto-generated method stub
		List<User> list =new ArrayList<>();
		try {
			
			String sql ="select * from tb_user ";
			con=DBManager.getConnection();
			ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				user =new User(
						rs.getInt("userId"), 
						rs.getString("userName"), 
						rs.getString("userPassword"), 
						rs.getString("userSex"), 
						rs.getInt("userAge"), 
						rs.getString("telephone"), 
						rs.getString("address"), 
						rs.getString("pic"), 
						rs.getInt("type"));
		
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	@Override
	public int deleteUserById(int userId) {
		con = DBManager.getConnection();
		String sql = "delete from tb_user where userId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int updateUser(int userId,String userName,String userSex,String userPassword,String address,int userAge,String telephone,int type) {
		con = DBManager.getConnection();
		String sql = "update tb_user set userName=?,userSex=?,userPassword=?, userAge=?,telephone=?,type=?,address=? where userId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, userSex);
			ps.setString(3, userPassword);
			ps.setInt(4, userAge);
			ps.setString(5, telephone);
			ps.setInt(6, type);
			ps.setString(7, address);
			ps.setInt(8, userId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int updatePwd(int userId, String pwd) {
		// TODO Auto-generated method stub
		
		try {
			con=DBManager.getConnection();
			String sql= "update tb_user set userPassword="+pwd+" where userId="+userId+" ";
			ps=con.prepareStatement(sql);
			System.out.println(sql);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

}
