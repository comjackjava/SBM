package com.jack.sbm.provider.service;

import java.util.List;

import com.jack.sbm.provider.bean.Provider;

public interface ProviderService {
	public List<Provider> getProvider();
	public int updateProvider(Provider provider);
	public int addProvider(Provider provider);
}
