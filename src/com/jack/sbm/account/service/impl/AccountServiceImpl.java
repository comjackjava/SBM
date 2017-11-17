package com.jack.sbm.account.service.impl;

import com.jack.sbm.account.dao.impl.AccountDaoImpl;
import com.jack.sbm.account.service.AccountService;
import com.jack.sbm.common.bean.PageBean;
import com.jack.sbm.goods.bean.Goods;

public class AccountServiceImpl implements AccountService {

	@Override
	public int addAccount(Goods goods, int providerId, int isPayed,
			int businessNum) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().addAccount(goods, providerId, isPayed, businessNum);
	}

	@Override
	public int deleteAccountById(int accountId) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().deleteAccountById(accountId);
	}

	@Override
	public int updateAccount(int accountId, int isPayed) {
		// TODO Auto-generated method stub
		return new AccountDaoImpl().updateAccount(accountId, isPayed);
	}

}
