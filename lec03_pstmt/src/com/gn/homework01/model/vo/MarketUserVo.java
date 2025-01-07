package com.gn.homework01.model.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MarketUserVo {
	private int userNo;
	private String userId;
	private String userPw;
	private String userNick;
	private LocalDateTime userRegdate;
	private LocalDateTime userModdate;
	public MarketUserVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MarketUserVo(int userNo, String userId, String userPw, String userNick, LocalDateTime userRegdate,
			LocalDateTime userModdate) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userNick = userNick;
		this.userRegdate = userRegdate;
		this.userModdate = userModdate;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public LocalDateTime getUserRegdate() {
		return userRegdate;
	}
	public void setUserRegdate(LocalDateTime userRegdate) {
		this.userRegdate = userRegdate;
	}
	public LocalDateTime getUserModdate() {
		return userModdate;
	}
	public void setUserModdate(LocalDateTime userModdate) {
		this.userModdate = userModdate;
	}
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년MM월dd일E요일");
		return "번호 : " + userNo + ", 아이디 : " + userId + ", 비밀번호 : " + userPw + ", 닉네임 : " + userNick
				+ ", 회원가입일 : " + userRegdate.format(dtf) + ", 수정일 : " + userModdate.format(dtf);
	}
	
	
}
