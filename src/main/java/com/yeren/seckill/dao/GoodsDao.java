package com.yeren.seckill.dao;

import com.yeren.seckill.mode.Goods;

public interface GoodsDao {
	boolean update(Goods goods);	
	Goods findById(Integer goodsId);
	boolean save(Goods goods);
	boolean delete(Integer goodsId);
}
