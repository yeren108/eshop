package com.yeren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yeren.dao.UserDao;
import com.yeren.mode.User;
import com.yeren.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	public boolean save(User user) {
		return userDao.save(user);
	}

	public boolean delete(Integer userId) {
		return userDao.delete(userId);
	}

	public boolean update(User user) {
		return userDao.update(user);
	}

	public User findById(Integer userId) {
		return userDao.findById(userId);
	}

}
