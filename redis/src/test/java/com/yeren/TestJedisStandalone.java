package com.yeren;

import com.yeren.constant.JedisStandalAloneConfig;
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
		Jedis jedis = new Jedis(JedisStandalAloneConfig.STANDAL_ALONE_HOST, JedisStandalAloneConfig.STANDAL_ALONE_PORT);
		jedis.auth(JedisStandalAloneConfig.STANDAL_ALONE_AUTH);
		//
		jedis.set("key1", "jedis test");
		System.out.println(jedis.get("key1"));
		jedis.del("key1");
	}
	
	@Test
	public void testJedisFlushAll() {
		// 创建jedis对象
		Jedis jedis = new Jedis(JedisStandalAloneConfig.STANDAL_ALONE_HOST, JedisStandalAloneConfig.STANDAL_ALONE_PORT);
		jedis.auth(JedisStandalAloneConfig.STANDAL_ALONE_AUTH);
		//
		jedis.flushAll();
		System.out.println(jedis.dbSize());
	}
}
