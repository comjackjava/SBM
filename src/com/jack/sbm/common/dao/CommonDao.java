package com.jack.sbm.common.dao;

import java.util.List;

import com.jack.sbm.common.bean.PageBean;

public interface CommonDao {
	public PageBean getCount(int p, String isPayed, String goodsName);
	public PageBean getUserCount(int p,String userName);
}
