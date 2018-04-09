package com.yeren.seckill.service;

import com.yeren.seckill.mode.Goods;

public interface GoodsService {
	boolean update(Goods goods);	
	Goods findById(Integer goodsId);
	boolean save(Goods goods);
	boolean delete(Integer goodsId);
}
