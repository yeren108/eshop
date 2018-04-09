package com.yeren.eshop.service;

import com.yeren.eshop.mode.Cart;
import com.yeren.eshop.mode.Goods;

public interface CartService {
	boolean update(Cart cart);	
	Cart findById(Integer cartId);
	boolean save(Cart cart);
	boolean delete(Integer cartId);
}
