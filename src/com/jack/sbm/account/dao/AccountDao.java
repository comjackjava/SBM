package com.jack.sbm.account.dao;

import com.jack.sbm.common.bean.PageBean;
import com.jack.sbm.goods.bean.Goods;

public interface AccountDao {
	public int addAccount(Goods goods, int providerId,int isPayed, int businessNum);
	public int deleteAccountById(int accountId);
	public int updateAccount(int accountId, int isPayed);	
}
