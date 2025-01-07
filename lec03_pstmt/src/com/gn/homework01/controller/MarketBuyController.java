package com.gn.homework01.controller;

import java.util.List;

import com.gn.homework01.model.dao.MarketBuyDao;
import com.gn.homework01.model.vo.MarketBuyVo;

public class MarketBuyController {
	MarketBuyDao mbd = new MarketBuyDao();
		public List<MarketBuyVo> searchBuyTable() {
			return mbd.searchBuyTable();
		}
		
		public int userBuyProduct(int userpNo, int userpSales, int uNo) {
			return mbd.userBuyProduct(userpNo, userpSales, uNo);
		}
}
