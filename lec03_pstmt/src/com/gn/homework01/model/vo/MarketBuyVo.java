package com.gn.homework01.model.vo;

public class MarketBuyVo {
	private int bNo;
	private int bUserNo;
	private int bProductNo;
	private int bSales;
	public MarketBuyVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MarketBuyVo(int bNo, int bUserNo, int bProductNo, int bSales) {
		super();
		this.bNo = bNo;
		this.bUserNo = bUserNo;
		this.bProductNo = bProductNo;
		this.bSales = bSales;
	}
	public int getbNo() {
		return bNo;
	}
	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	public int getbUserNo() {
		return bUserNo;
	}
	public void setbUserNo(int bUserNo) {
		this.bUserNo = bUserNo;
	}
	public int getbProductNo() {
		return bProductNo;
	}
	public void setbProductNo(int bProductNo) {
		this.bProductNo = bProductNo;
	}
	public int getbSales() {
		return bSales;
	}
	public void setbSales(int bSales) {
		this.bSales = bSales;
	}
	@Override
	public String toString() {
		return "구매 번호 : " + bNo 
				+ ", 사용자 번호 : " + bUserNo 
				+ ", 제품 번호 : " + bProductNo 
				+ ", 구매 개수 : " + bSales;
	}
	
	
}
