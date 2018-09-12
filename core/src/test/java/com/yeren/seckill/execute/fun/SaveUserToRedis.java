package com.yeren.seckill.execute.fun;

import com.yeren.mode.User;
import com.yeren.service.UserService;

import redis.clients.jedis.Jedis;

public class SaveUserToRedis {
	
	
	/**
	 * 往redis中添加用户
	 * @param jedis
	 * @param userService
	 * @param startId
	 * @param endId
	 * @return 添加用户个数
	 */
	public synchronized Integer save(Jedis jedis,UserService userService,Integer startId,Integer endId){
		int num=0;
		for(int i=startId;i<endId;i++){
			User user = userService.findById(i+1);
			if(user!=null){
				if(user.getLogin()==1){
					jedis.hsetnx("seckill:"+user.getUserId().toString(),"id", user.getUserId().toString());
					jedis.hsetnx("seckill:"+user.getUserId().toString(),"username", user.getUserName().toString());
					jedis.hsetnx("seckill:"+user.getUserId().toString(),"password", user.getPassword().toString());
					jedis.hsetnx("seckill:"+user.getUserId().toString(),"mobile", user.getMobile().toString());
					jedis.hsetnx("seckill:"+user.getUserId().toString(),"address", user.getAddress().toString());
					jedis.hsetnx("seckill:"+user.getUserId().toString(),"login", user.getLogin().toString());
					jedis.hsetnx("seckill:"+user.getUserId().toString(),"seckill", user.getSeckill().toString());
					num++;
				}
			}
		}
		return num;
	}
}
