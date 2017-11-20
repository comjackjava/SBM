package com.jack.sbm.common.service.impl;



import com.jack.sbm.common.bean.PageBean;
import com.jack.sbm.common.dao.impl.CommonDaoImpl;
import com.jack.sbm.common.service.CommonService;


public class CommonServiceImpl implements CommonService {

	@Override
	public PageBean getCount(int p, String isPayed, String goodsName) {
		// TODO Auto-generated method stub
		return new CommonDaoImpl().getCount(p, isPayed, goodsName);
	}

	@Override
	public PageBean getUserCount(int p, String userName) {
		// TODO Auto-generated method stub
		return new CommonDaoImpl().getUserCount(p, userName);
	}









}
