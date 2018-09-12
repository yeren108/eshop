package com.yeren.dao;

import com.yeren.mode.Goods;

public interface GoodsDao {
	boolean update(Goods goods);	
	Goods findById(Integer goodsId);
	boolean save(Goods goods);
	boolean delete(Integer goodsId);
}
