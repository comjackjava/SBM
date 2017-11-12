package com.jack.sbm.account.bean;

import java.sql.Date;

/**
 * @author jayli
 * 账单
 */
public class Account {
	private int accountId;
	private int providerId;
	private float totalPrice;
	private int isPayed;
	private Date accountDate;
	private int goodsId;
	private int businessNum;
	
	public Account(int accountId, int providerId, float totalPrice,
			int isPayed, Date accountDate, int goodsId, int businessNum) {
		super();
		this.accountId = accountId;
		this.providerId = providerId;
		this.totalPrice = totalPrice;
		this.isPayed = isPayed;
		this.accountDate = accountDate;
		this.goodsId = goodsId;
		this.businessNum = businessNum;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getIsPayed() {
		return isPayed;
	}
	public void setIsPayed(int isPayed) {
		this.isPayed = isPayed;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getBusinessNum() {
		return businessNum;
	}
	public void setBusinessNum(int businessNum) {
		this.businessNum = businessNum;
	}
}
