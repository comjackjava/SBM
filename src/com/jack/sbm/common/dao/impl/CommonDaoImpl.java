package com.jack.sbm.common.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jack.sbm.account.bean.AccountDetail;
import com.jack.sbm.common.bean.PageBean;
import com.jack.sbm.common.dao.CommonDao;
import com.jack.sbm.user.bean.User;
import com.jack.sbm.utils.DBManager;

public class CommonDaoImpl implements CommonDao {
private Connection con;
private PreparedStatement ps;
	@Override
	public PageBean getCount(int p,String isPayed ,String  goodsName ) {
		PageBean pb =new PageBean();
		AccountDetail accountDetail =null;
		try {
			String sql=null;
			if("".equals(goodsName)){
				goodsName="''";
			}//全都有参数
			if(goodsName!=null&&!"''".equals(goodsName)&&!"2".equals(isPayed)){
				 sql="select count(*) as cnt from tb_goods g   join  tb_account a on  a.goodsId=g.goodsId   join tb_provider p on p.providerId=a.providerId where  a.isPayed="+isPayed+" and g.goodsName="+goodsName;
			}else if((goodsName ==null&&"2".equals(isPayed))||("''".equals(goodsName)&&"2".equals(isPayed))){
				 sql="select count(*) as cnt from tb_goods g   join  tb_account a on  a.goodsId=g.goodsId   join tb_provider p on p.providerId=a.providerId ";
			}else  {
				 sql="select count(*) as cnt from tb_goods g   join  tb_account a on  a.goodsId=g.goodsId   join tb_provider p on p.providerId=a.providerId where  a.isPayed="+isPayed+" or g.goodsName="+goodsName;
			}
			con=DBManager.getConnection();
			System.out.println(sql);
			ps=con.prepareStatement(sql);
			ResultSet rs1=ps.executeQuery();
			if(rs1.next()){
				pb.setPageSize(5);
				pb.setCount(rs1.getInt("cnt"));
				pb.setP(p);
				
			}
			rs1.close();
			if("".equals(goodsName)){
				goodsName="''";
			}//全都有参数
			if(goodsName!=null&&!"''".equals(goodsName)&&!"2".equals(isPayed)){
				 sql="select top "+pb.getPageSize()+ " * from tb_goods g   join  tb_account a on  a.goodsId=g.goodsId   join tb_provider p on p.providerId=a.providerId where  a.isPayed="+isPayed+" and g.goodsName="+goodsName+" and a.accountId not in (select top "+(pb.getP()-1)*pb.getPageSize()+"  a.accountId from tb_goods g   join  tb_account a on  a.goodsId=g.goodsId   join tb_provider p on p.providerId=a.providerId where  a.isPayed="+isPayed+" and g.goodsName="+goodsName+" );";
			}else if((goodsName ==null&&"2".equals(isPayed))||("''".equals(goodsName)&&"2".equals(isPayed))){
				 sql="select top "+pb.getPageSize()+ " * from tb_goods g   join  tb_account a on  a.goodsId=g.goodsId   join tb_provider p on p.providerId=a.providerId where a.accountId not in (select top "+(pb. getP()-1)*pb.getPageSize()+"  a.accountId from tb_goods g   join  tb_account a on  a.goodsId=g.goodsId   join tb_provider p on p.providerId=a.providerId );";
			}else  {
				 sql="select top "+pb.getPageSize()+ " * from tb_goods g   join  tb_account a on  a.goodsId=g.goodsId   join tb_provider p on p.providerId=a.providerId where  a.isPayed="+isPayed+" or g.goodsName="+goodsName+" and a.accountId not in (select top "+(pb.getP()-1)*pb.getPageSize()+" a.accountId from tb_goods g   join  tb_account a on  a.goodsId=g.goodsId   join tb_provider p on p.providerId=a.providerId where  a.isPayed="+isPayed+" and g.goodsName="+goodsName+" );";
			}
			System.out.println(sql);
			System.out.println(sql);
			ps=con.prepareStatement(sql);
			ResultSet rs2 = ps.executeQuery();
		   while(rs2.next()){
			   accountDetail = new AccountDetail(
						rs2.getInt("accountId"), 
						rs2.getString("goodsName"), 
						rs2.getInt("businessNum"),
						rs2.getInt("goodsNum"), 
						rs2.getFloat("totalPrice"), 
						rs2.getInt("isPayed"), 
						rs2.getString("providerName"), 
						rs2.getString("goodsIntro"), 
						rs2.getDate("accountDate"));
				pb.addData(accountDetail);
		   }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBManager.close(ps, con);
		}
		
		return pb;
	}
	@Override
	public PageBean getUserCount(int p, String userName) {
		// TODO Auto-generated method stub
		PageBean pageBean =new PageBean();
		User user =null;
		String sql=null;
		if(userName!=null&&!"".equals(userName)){
			sql="select count(*) as cnt from tb_user where userName='"+userName+"'";
		}else{
			sql="select count(*) as cnt from tb_user";
		}
	System.out.println(sql);
		try {
			con=DBManager.getConnection();
			ps=con.prepareStatement(sql);
			ResultSet rs1=ps.executeQuery();
			if(rs1.next()){
				pageBean.setPageSize(5);
				pageBean.setCount(rs1.getInt("cnt"));
				pageBean.setP(p);
			}
			
			if(userName!=null&&!"".equals(userName)){
				sql="select top "+pageBean.getPageSize()+ " * from tb_user where userName='"+userName+"' and userId not in (select top "+(pageBean. getP()-1)*pageBean.getPageSize()+" userId from tb_user where userName='"+userName+"')";
			}else{
				sql="select top "+pageBean.getPageSize()+ " * from tb_user where  userId not in (select top "+(pageBean. getP()-1)*pageBean.getPageSize()+" userId from tb_user )";
			}
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
		
				pageBean.addData(user);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pageBean;
	}

}
