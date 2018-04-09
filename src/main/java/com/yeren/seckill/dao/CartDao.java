package com.yeren.seckill.dao;

import com.yeren.seckill.mode.Cart;
import com.yeren.seckill.mode.User;

public interface CartDao {
	boolean save(Cart cart);
	boolean delete(Integer cartId);
	boolean update(Cart cart);	
	Cart findById(Integer cartId);
}
