package com.jack.sbm.common.service;

import java.util.List;

import com.jack.sbm.common.bean.PageBean;

public interface CommonService {
	public PageBean getCount(int p,String isPayed ,String goodsName);
	public PageBean getUserCount(int p,String userName);
	public PageBean getProviderCount(int p,String providerName,String providerDetail);
}
