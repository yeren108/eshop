package com.yeren;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context-test.xml")
public class TestJedisStandalone {

	// 单实例链接测试
	@Test
	public void testJedisSingel() {
		// 创建jedis对象
		Jedis jedis = new Jedis("139.199.124.81", 6370);
		jedis.auth("foobared");
		//
		jedis.set("key1", "jedis test");
		System.out.println(jedis.get("key1"));
		jedis.del("key1");
	}
	
	@Test
	public void testJedisFlushAll() {
		// 创建jedis对象
		Jedis jedis = new Jedis("139.199.124.81", 6370);
		jedis.auth("foobared");
		//
		jedis.flushAll();
		System.out.println(jedis.dbSize());
	}
}
