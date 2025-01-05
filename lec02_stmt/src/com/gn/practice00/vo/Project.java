package com.gn.practice00.vo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Project {
	private int member_no;
	private String member_id;
	private String member_pwd;
	private String member_name;
	private String adress;
	private String phone;
	private String status;
	private LocalDateTime reg_date;
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(int member_no, String member_id, String member_pwd, String member_name, String adress, String phone,
			String status, LocalDateTime reg_date) {
		super();
		this.member_no = member_no;
		this.member_id = member_id;
		this.member_pwd = member_pwd;
		this.member_name = member_name;
		this.adress = adress;
		this.phone = phone;
		this.status = status;
		this.reg_date = reg_date;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pwd() {
		return member_pwd;
	}
	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getReg_date() {
		return reg_date;
	}
	public void setReg_date(LocalDateTime reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return "회원번호:" + member_no + ", 아이디:" + member_id + ", 비밀번호:" + member_pwd
				+ ", 이름:" + member_name + ", 주소:" + adress + ", 전화번호:" + phone + ", 탈퇴여부:" + status
				+ ", 등록일:" + reg_date.format(dtf);
	}
	
	
	
}
