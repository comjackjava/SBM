package com.jack.sbm.provider.dao;

import java.util.List;

import com.jack.sbm.provider.bean.Provider;

public interface ProviderDao {
	public List<Provider> getProvider();
	public int updateProvider(Provider provider);
	public int addProvider(Provider provider);
}
