package com.gn.homework01.controller;

import com.gn.homework01.model.dao.MarketDao;
import com.gn.homework01.model.vo.MarketUserVo;

public class MarketController {
	private MarketDao md = new MarketDao();
	
	public int createUser(String createId, String createPw, String createNick) {
		int result = md.createUser(createId, createPw, createNick);
		return result;
	}
	
	public MarketUserVo login(String loginId, String loginPw) {
		return md.login(loginId, loginPw);
	}
	
	public int editeNick(String uId, String newNick) {
		return  md.editeNick(uId, newNick);
	}
	
	public int deleteUser(String uId) {
		return md.deleteUser(uId);
	}
}
