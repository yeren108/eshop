package com.yeren.eshop.dao;

import com.yeren.eshop.mode.User;

public interface UserDao {
	boolean save(User user);
	boolean delete(Integer userId);
	boolean update(User user);	
	User findById(Integer userId);
}
