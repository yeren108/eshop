package com.yeren.dao;

import com.yeren.mode.User;

public interface UserDao {
	boolean save(User user);
	boolean delete(Integer userId);
	boolean update(User user);	
	User findById(Integer userId);
}
