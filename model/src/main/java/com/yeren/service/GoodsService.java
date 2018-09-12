package com.yeren.service;

import com.yeren.mode.Goods;

public interface GoodsService {
	boolean update(Goods goods);	
	Goods findById(Integer goodsId);
	boolean save(Goods goods);
	boolean delete(Integer goodsId);
}
