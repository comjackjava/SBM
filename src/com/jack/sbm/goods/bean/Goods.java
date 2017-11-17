package com.jack.sbm.goods.bean;

/**
 * @author jayli
 * 商品
 */
public class Goods {
	private int goodsId;
	private String goodsName="";
	private int goodsNum;
	private float goodsPrice;
	private String goodsUnit="";
	private String goodsIntro="";
	
	public Goods(int goodsId, String goodsName, int goodsNum, float goodsPrice,
			String goodsUnit, String goodsIntro) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsNum = goodsNum;
		this.goodsPrice = goodsPrice;
		this.goodsUnit = goodsUnit;
		this.goodsIntro = goodsIntro;
	}

	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public int getGoodsNum() {
		return goodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsUnit() {
		return goodsUnit;
	}
	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}
	public String getGoodsIntro() {
		return goodsIntro;
	}
	public void setGoodsIntro(String goodsIntro) {
		this.goodsIntro = goodsIntro;
	}
}
