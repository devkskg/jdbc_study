package com.gn.practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Vo {
	public int no;
	public String name;
	public LocalDateTime date;
	
	public Vo() {}
	public Vo(int no, String name, LocalDateTime date) {
		this.no = no;
		this.name = name;
		this.date = date;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	
	
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분SS초");
		return "번호:" + no + ", 이름:" + name + ", 등록일:" + date.format(dtf);
	}
	
}
