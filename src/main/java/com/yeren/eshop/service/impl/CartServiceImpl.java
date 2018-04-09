package com.yeren.eshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeren.eshop.dao.CartDao;
import com.yeren.eshop.mode.Cart;
import com.yeren.eshop.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	CartDao cartDao;

	public boolean update(Cart cart) {
		return cartDao.update(cart);
	}

	public Cart findById(Integer cartId) {
		return cartDao.findById(cartId);
	}

	public boolean save(Cart cart) {
		return cartDao.save(cart);
	}

	public boolean delete(Integer cartId) {
		return cartDao.delete(cartId);
	}



}
