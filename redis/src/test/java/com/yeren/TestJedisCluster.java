package com.yeren;

import com.yeren.constant.JedisClusterConfig;
import com.yeren.constant.JedisStandalAloneConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;

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
		nodes.add(new HostAndPort(JedisClusterConfig.JEDIS_CLUSTER_HOST1, JedisClusterConfig.JEDIS_CLUSTER_PORT1));
		nodes.add(new HostAndPort(JedisClusterConfig.JEDIS_CLUSTER_HOST2, JedisClusterConfig.JEDIS_CLUSTER_PORT2));
		nodes.add(new HostAndPort(JedisClusterConfig.JEDIS_CLUSTER_HOST3, JedisClusterConfig.JEDIS_CLUSTER_PORT3));
		nodes.add(new HostAndPort(JedisClusterConfig.JEDIS_CLUSTER_HOST4, JedisClusterConfig.JEDIS_CLUSTER_PORT4));
		nodes.add(new HostAndPort(JedisClusterConfig.JEDIS_CLUSTER_HOST5, JedisClusterConfig.JEDIS_CLUSTER_PORT5));
		nodes.add(new HostAndPort(JedisClusterConfig.JEDIS_CLUSTER_HOST6, JedisClusterConfig.JEDIS_CLUSTER_PORT6));
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
		Jedis jedis = new Jedis(JedisStandalAloneConfig.STANDAL_ALONE_HOST, JedisStandalAloneConfig.STANDAL_ALONE_PORT);
		jedis.auth(JedisStandalAloneConfig.STANDAL_ALONE_AUTH);
		// 调用jedis对象方法，方法名和Jedis命令一致
		// jedis.set("key1", "jedis test");
		String string = jedis.get("a");
		System.out.println(string);
	}
}
