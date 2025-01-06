package com.gn.homework01.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WMUser {
	private int u_no;
	private String u_id;
	private String u_pw;
	private String u_name;
	private LocalDateTime u_regdate;
	public WMUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WMUser(int u_no, String u_id, String u_pw, String u_name, LocalDateTime u_regdate) {
		super();
		this.u_no = u_no;
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_regdate = u_regdate;
	}
	public int getU_no() {
		return u_no;
	}
	public void setU_no(int u_no) {
		this.u_no = u_no;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public LocalDateTime getU_regdate() {
		return u_regdate;
	}
	public void setU_regdate(LocalDateTime u_regdate) {
		this.u_regdate = u_regdate;
	}
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년MM월dd일");
		return "사용자 번호:" + u_no + ", 아이디:" + u_id + ", 비밀번호:" + u_pw + ", 이름:" + u_name + ", 회원가입일:"
				+ u_regdate.format(dtf) ;
	}
	
	
}
