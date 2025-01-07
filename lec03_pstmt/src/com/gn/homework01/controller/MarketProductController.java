package com.gn.homework01.controller;

import java.util.List;

import com.gn.homework01.model.dao.MarketProductDao;
import com.gn.homework01.model.vo.MarketProductVo;

public class MarketProductController {
	MarketProductDao mpd = new MarketProductDao();
	
	public int createProduct(String createpName, int createpPrice, int createpImport) {
		return mpd.createProduct(createpName, createpPrice, createpImport);
	}
	public int importProduct(int importpNo, int importpImport) {
		return mpd.importProduct(importpNo, importpImport);
	}
	
	public List<MarketProductVo> searchProductTable(){
		return mpd.searchProductTable();
	}
}
