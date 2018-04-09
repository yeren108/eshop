package com.yeren.seckill.service;

import com.yeren.seckill.mode.User;

public interface UserService {
	boolean save(User user);
	boolean delete(Integer userId);
	boolean update(User user);	
	User findById(Integer userId);
}
