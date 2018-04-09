package com.yeren.eshop.service;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context-test.xml")
public class TestJedisCluster {

	@Test
	public void testJedisCluster() throws Exception {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		// 最大空闲连接数
		poolConfig.setMaxIdle(10);
		// 连接池中最大连接数
		poolConfig.setMaxTotal(100);
		// 在获取链接的时候设置的超市时间
		poolConfig.setMaxWaitMillis(1000);
		// 表示在向连接池中创建连接的时候会对链接进行测试，保证连接池中的链接都是可用的。
		poolConfig.setTestOnBorrow(true);
		
		HashSet<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("139.199.124.81", 6379));
		nodes.add(new HostAndPort("139.199.124.81", 6380));
		nodes.add(new HostAndPort("139.199.124.81", 6381));
		nodes.add(new HostAndPort("139.199.124.81", 6382));
		nodes.add(new HostAndPort("139.199.124.81", 6383));
		nodes.add(new HostAndPort("139.199.124.81", 6384));
		JedisCluster cluster = new JedisCluster(nodes);
		cluster.set("key1", "test");
		String string = cluster.get("key1");
		System.out.println(string);
		cluster.close();
	}

	// 单实例链接测试
	// @Test
	public void testJedisSingel() {
		// 创建jedis对象
		Jedis jedis = new Jedis("139.199.124.81", 6381);
		// 调用jedis对象方法，方法名和Jedis命令一致
		// jedis.set("key1", "jedis test");
		String string = jedis.get("a");
		System.out.println(string);
	}
}
