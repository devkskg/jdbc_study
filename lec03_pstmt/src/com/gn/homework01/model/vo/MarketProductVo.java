package com.gn.homework01.model.vo;

public class MarketProductVo {
	private int pNo;
	private String pName;
	private int pPrice;
	private int pAmount;
	public MarketProductVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MarketProductVo(int pNo, String pName, int pPrice, int pAmount) {
		super();
		this.pNo = pNo;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pAmount = pAmount;
	}
	public int getpNo() {
		return pNo;
	}
	public void setpNo(int pNo) {
		this.pNo = pNo;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public int getpAmount() {
		return pAmount;
	}
	public void setpAmount(int pAmount) {
		this.pAmount = pAmount;
	}
	@Override
	public String toString() {
		return "제품 번호 : " + pNo 
				+ ", 제품명 : " + pName 
				+ ", 제품 가격 : " + pPrice 
				+ ", 제품 총량 : " + pAmount;
	}
	
	
}
