package com.jack.sbm.account.service;

import com.jack.sbm.common.bean.PageBean;
import com.jack.sbm.goods.bean.Goods;

public interface AccountService {

	public int addAccount(Goods goods, int providerId,int isPayed, int businessNum);
	public int deleteAccountById(int accountId);
	public int updateAccount(int accountId, int isPayed);
}