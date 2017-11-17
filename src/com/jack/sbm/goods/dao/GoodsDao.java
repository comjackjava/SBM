package com.jack.sbm.goods.dao;

import com.jack.sbm.goods.bean.Goods;

public interface GoodsDao {
	public int updateGoods(int goodsNum, int goodsId);
	public Goods getGoodsInfoByName(String goodsName);
}
