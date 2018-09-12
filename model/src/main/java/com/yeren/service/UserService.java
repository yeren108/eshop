package com.yeren.service;

import com.yeren.mode.User;

public interface UserService {
	boolean save(User user);
	boolean delete(Integer userId);
	boolean update(User user);	
	User findById(Integer userId);
}
