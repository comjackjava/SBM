package com.jack.sbm.account.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jack.sbm.account.dao.AccountDao;
import com.jack.sbm.common.bean.PageBean;
import com.jack.sbm.goods.bean.Goods;
import com.jack.sbm.utils.DBManager;

public class AccountDaoImpl implements AccountDao{
private Connection con;
private PreparedStatement ps;
	@Override
	public int addAccount(Goods goods, int providerId, int isPayed,
			int businessNum) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "insert into tb_account values (?,?,?,getDate(),?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, providerId);
			ps.setFloat(2, businessNum*goods.getGoodsPrice());
			ps.setInt(3, isPayed);
			ps.setInt(4, goods.getGoodsId());
			ps.setInt(5, businessNum);
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteAccountById(int accountId) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "delete from tb_account where accountId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, accountId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateAccount(int accountId, int isPayed) {
		// TODO Auto-generated method stub
		con = DBManager.getConnection();
		String sql = "update tb_account set isPayed = ? where accountId = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, isPayed);
			ps.setInt(2, accountId);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}


}
