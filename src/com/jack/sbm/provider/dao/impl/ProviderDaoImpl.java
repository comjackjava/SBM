package com.jack.sbm.provider.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jack.sbm.provider.bean.Provider;
import com.jack.sbm.provider.dao.ProviderDao;
import com.jack.sbm.utils.DBManager;

public class ProviderDaoImpl implements ProviderDao {
private Connection con;
private PreparedStatement ps;
	@Override
	public List<Provider> getProvider() {
		// TODO Auto-generated method stub
		List<Provider> list = new ArrayList<>();
		Provider provider = null;
		con = DBManager.getConnection();
		String sql = "select * from tb_provider";
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				provider = new Provider(
						rs.getInt("providerId"), 
						rs.getString("providerName"), 
						rs.getString("providerDetail"), 
						rs.getString("contact"), 
						rs.getString("telephone"), 
						rs.getString("facsimile"), 
						rs.getString("address"));
				list.add(provider);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int updateProvider(Provider provider) {
		// TODO Auto-generated method stub
		try {
			con=DBManager.getConnection();
			String sql ="update  tb_provider set providerName=?,providerDetail=?,contact=?,telephone=?,facsimile=?,address=? where providerId=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, provider.getProviderName());
			ps.setString(2, provider.getProviderDetail());
			ps.setString(3, provider.getContact());
			ps.setString(4, provider.getTelephone());
			ps.setString(5, provider.getFacsimile());
			ps.setString(6, provider.getAddress());
			ps.setInt(7, provider.getProviderId());
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public int addProvider(Provider provider) {
		// TODO Auto-generated method stub
		try {
			con=DBManager.getConnection();
			String sql ="insert into tb_provider values(?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, provider.getProviderName());
			ps.setString(2, provider.getProviderDetail());
			ps.setString(3, provider.getContact());
			ps.setString(4, provider.getTelephone());
			ps.setString(5, provider.getFacsimile());
			ps.setString(6, provider.getAddress());
			return  ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
