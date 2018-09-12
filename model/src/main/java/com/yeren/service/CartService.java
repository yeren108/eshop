package com.yeren.service;

import com.yeren.mode.Cart;
import com.yeren.mode.Goods;

public interface CartService {
	boolean update(Cart cart);	
	Cart findById(Integer cartId);
	boolean save(Cart cart);
	boolean delete(Integer cartId);
}
