package com.yeren.eshop.service;

import com.yeren.eshop.mode.User;

public interface UserService {
	boolean save(User user);
	boolean delete(Integer userId);
	boolean update(User user);	
	User findById(Integer userId);
}
