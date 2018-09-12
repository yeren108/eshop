package com.yeren.seckill.execute.thread;

import com.yeren.seckill.execute.fun.SaveUserToRedis;
import com.yeren.seckill.service.UserService;

import redis.clients.jedis.Jedis;

public class SaveUserToRedisThead implements Runnable{
	private Jedis jedis;
	private UserService userService;
	private Integer startId;
	private Integer endId;

	public SaveUserToRedisThead(Jedis jedis, UserService userService, int startId, int endId) {
		this.jedis=jedis;
		this.userService=userService;
		this.startId=startId;
		this.endId=endId;
	}

	@Override
	public void run() {
		SaveUserToRedis su=new SaveUserToRedis();
		su.save(jedis, userService, startId, endId);
	}
	
	public Jedis getJedis() {
		return jedis;
	}

	public void setJedis(Jedis jedis) {
		this.jedis = jedis;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Integer getStartId() {
		return startId;
	}

	public void setStartId(Integer startId) {
		this.startId = startId;
	}

	public Integer getEndId() {
		return endId;
	}

	public void setEndId(Integer endId) {
		this.endId = endId;
	}


}
