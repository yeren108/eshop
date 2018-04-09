package com.yeren.eshop.dao;

import com.yeren.eshop.mode.Goods;

public interface GoodsDao {
	boolean update(Goods goods);	
	Goods findById(Integer goodsId);
	boolean save(Goods goods);
	boolean delete(Integer goodsId);
}
