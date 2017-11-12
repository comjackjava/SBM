package com.jack.sbm.provider.bean;

/**
 * @author jayli
 * 供应商
 */
public class Provider {
	private int providerId;
	private String providerName = "";
	private String providerDetail = "";
	private String contact = "";
	private String telephone = "";
	private String facsimile = "";
	private String address = "";
	
	public Provider() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public String getProviderDetail() {
		return providerDetail;
	}
	public void setProviderDetail(String providerDetail) {
		this.providerDetail = providerDetail;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFacsimile() {
		return facsimile;
	}
	public void setFacsimile(String facsimile) {
		this.facsimile = facsimile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
