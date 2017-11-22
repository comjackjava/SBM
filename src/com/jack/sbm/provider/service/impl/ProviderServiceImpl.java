package com.jack.sbm.provider.service.impl;



import java.util.List;

import com.jack.sbm.provider.bean.Provider;
import com.jack.sbm.provider.dao.impl.ProviderDaoImpl;
import com.jack.sbm.provider.service.ProviderService;

public class ProviderServiceImpl implements ProviderService {

	@Override
	public List<Provider> getProvider() {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().getProvider();
	}

	@Override
	public int updateProvider(Provider provider) {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().updateProvider(provider);
	}

	@Override
	public int addProvider(Provider provider) {
		// TODO Auto-generated method stub
		return new ProviderDaoImpl().addProvider(provider);
	}

}
