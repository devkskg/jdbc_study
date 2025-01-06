package com.gn.homework01.vo;

import java.util.Objects;

public class WMSong /*implements Comparable<WMSong>*/ {
	private int s_no;
	private String s_title;
	private String s_artist;
	private int s_count;
	public WMSong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WMSong(int s_no, String s_title, String s_artist, int s_count) {
		super();
		this.s_no = s_no;
		this.s_title = s_title;
		this.s_artist = s_artist;
		this.s_count = s_count;
	}
	public int getS_no() {
		return s_no;
	}
	public void setS_no(int s_no) {
		this.s_no = s_no;
	}
	public String getS_title() {
		return s_title;
	}
	public void setS_title(String s_title) {
		this.s_title = s_title;
	}
	public String getS_artist() {
		return s_artist;
	}
	public void setS_artist(String s_artist) {
		this.s_artist = s_artist;
	}
	public int getS_count() {
		return s_count;
	}
	public void setS_count(int s_count) {
		this.s_count = s_count;
	}
	@Override
	public String toString() {
		return "음악번호:" + s_no + ", 제목:" + s_title + ", 아티스트:" + s_artist + ", 재생횟수:" + s_count;
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(s_artist, s_count, s_no, s_title);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		WMSong other = (WMSong) obj;
//		return Objects.equals(s_artist, other.s_artist) && s_count == other.s_count && s_no == other.s_no
//				&& Objects.equals(s_title, other.s_title);
//	}
//	@Override
//	public int compareTo(WMSong other) {
//		return Integer.compare(this.s_no, other.s_no);
//	}
	
	
	
}
