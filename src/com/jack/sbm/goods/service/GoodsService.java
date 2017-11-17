package com.jack.sbm.goods.service;

import com.jack.sbm.goods.bean.Goods;

public interface GoodsService {
	public int updateGoods(int goodsNum, int goodsId);
	public Goods getGoodsInfoByName(String goodsName);
}
