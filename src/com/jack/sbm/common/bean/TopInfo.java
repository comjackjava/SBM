package com.jack.sbm.common.bean;

public class TopInfo {

private String goodsName;
private String isPayed;
public TopInfo(String goodsName, String isPayed) {
	super();
	this.goodsName = goodsName;
	this.isPayed = isPayed;
}

public TopInfo() {
	super();
	// TODO Auto-generated constructor stub
}

public String getGoodsName() {
	return goodsName;
}
public void setGoodsName(String goodsName) {
	this.goodsName = goodsName;
}
public String getIsPayed() {
	return isPayed;
}
public void setIsPayed(String isPayed) {
	this.isPayed = isPayed;
}
}
