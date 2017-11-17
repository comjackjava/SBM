package com.jack.sbm.common.bean;

import java.util.ArrayList;
import java.util.List;

public class PageBean {
	private int pageSize;
	private int pageTotal;
	private int p;
	private int count ;
	private List data;

	public PageBean(int pageSize, int pageTotal, int p, int count, List data) {
		super();
		this.pageSize = pageSize;
		this.pageTotal = pageTotal;
		this.p = p;
		this.count = count;
		this.data = data;
	}
	public PageBean() {
		super();
		p=1;
		pageSize=5;
		data=new ArrayList<>();
		
		// TODO Auto-generated constructor stub
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getP() {
		return p;
	}
	public void setP(int p) {
		if(p<1)p=1;
		else if(p>pageTotal)p=pageTotal;
		else this.p=p;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		pageTotal=(int)Math.ceil(count*1.0/pageSize);
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public void addData(Object obj){
		data.add(obj);
	}
	}
