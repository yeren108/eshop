package com.yeren.seckill.execute;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
/**
 * 取出redis中购买的用户
 * @author ThinkPad
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context-test.xml")
public class ListSeckillUserFromRedisExecute {
	
	@Test
	public void saveUser() throws IOException{
		Jedis jedis=new Jedis("139.199.124.81", 6370);
		jedis.auth("foobared");
		
		for(int i=0;i<5000;i++){
			String hget = jedis.hget("sekill:"+String.valueOf(i), "seckill");
			if("1".equals(hget)){
				System.out.println("sekill:"+i);
			}
		}

	}
}
