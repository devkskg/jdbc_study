package com.gn.homework01.controller;

import java.util.List;

import com.gn.homework01.dao.WMDao;
import com.gn.homework01.vo.WMSong;
import com.gn.homework01.vo.WMUser;

public class WMController {
	WMDao d = new WMDao();
			
	public WMUser login(String id, String pw) {
		return d.login(id, pw);
	}
	
	public int joinMember(String id, String pw, String name) {
		return d.joinMember(id, pw, name);
	}
	
	public int addPlayList(String title, String artist) {
		return d.addPlayList(title, artist);
	}
	
	public List<WMSong> searchTopSong(){
		return d.searchTopSong();
	}
	public List<WMSong> searchAllSong(){
		return d.searchTopSong();
	}
	public int selectSongNum(int songNum) {
		return d.selectSongNum(songNum);
	}
	public int changeUserName(String newName, String wmid, String wmpw) {
		return d.changeUserName(newName, wmid, wmpw);
	}
	public int deleteId(String wmid, String wmpw) {
		return d.deleteId(wmid, wmpw);
	}
	
}
