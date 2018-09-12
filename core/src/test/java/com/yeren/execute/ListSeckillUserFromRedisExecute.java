package com.yeren.execute;

import java.io.IOException;

import com.yeren.constant.JedisStandalAloneConfig;
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
		Jedis jedis=new Jedis(JedisStandalAloneConfig.STANDAL_ALONE_HOST, JedisStandalAloneConfig.STANDAL_ALONE_PORT);
		jedis.auth(JedisStandalAloneConfig.STANDAL_ALONE_AUTH);
		
		for(int i=0;i<5000;i++){
			String hget = jedis.hget("sekill:"+String.valueOf(i), "seckill");
			if("1".equals(hget)){
				System.out.println("sekill:"+i);
			}
		}

	}
}
