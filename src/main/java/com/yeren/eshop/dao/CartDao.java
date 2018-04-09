package com.yeren.eshop.dao;

import com.yeren.eshop.mode.Cart;
import com.yeren.eshop.mode.User;

public interface CartDao {
	boolean save(Cart cart);
	boolean delete(Integer cartId);
	boolean update(Cart cart);	
	Cart findById(Integer cartId);
}
