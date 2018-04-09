package com.yeren.eshop.service;

import com.yeren.eshop.mode.Goods;

public interface GoodsService {
	boolean update(Goods goods);	
	Goods findById(Integer goodsId);
	boolean save(Goods goods);
	boolean delete(Integer goodsId);
}
