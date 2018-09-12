package com.yeren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeren.dao.GoodsDao;
import com.yeren.mode.Goods;
import com.yeren.service.GoodsService;
@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	GoodsDao goodsDao;

	public boolean update(Goods goods) {
		return goodsDao.update(goods);
	}

	public Goods findById(Integer goodsId) {
		return goodsDao.findById(goodsId);
	}

	public boolean save(Goods goods) {
		return goodsDao.save(goods);
	}

	public boolean delete(Integer goodsId) {
		return goodsDao.delete(goodsId);
	}
	
	
	
}
