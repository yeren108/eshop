package com.yeren.dao;

import com.yeren.mode.Cart;
import com.yeren.mode.User;

public interface CartDao {
	boolean save(Cart cart);
	boolean delete(Integer cartId);
	boolean update(Cart cart);	
	Cart findById(Integer cartId);
}
