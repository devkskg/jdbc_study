package com.gn.homework01.controller;

import com.gn.homework01.model.dao.MarketDao;
import com.gn.homework01.model.vo.MarketUserVo;

public class MarketController {
	MarketDao md = new MarketDao();
	
	public int createUser(String createId, String createPw, String createNick) {
		int result = md.createUser(createId, createPw, createNick);
		return result;
	}
	
	public MarketUserVo login(String loginId, String loginPw) {
		return md.login(loginId, loginPw);
	}
}
