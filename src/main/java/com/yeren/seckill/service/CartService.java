package com.yeren.seckill.service;

import com.yeren.seckill.mode.Cart;
import com.yeren.seckill.mode.Goods;

public interface CartService {
	boolean update(Cart cart);	
	Cart findById(Integer cartId);
	boolean save(Cart cart);
	boolean delete(Integer cartId);
}
