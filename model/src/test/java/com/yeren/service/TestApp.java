package com.yeren.service;

import com.yeren.service.GoodsService;
import com.yeren.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context-test.xml")
public class TestApp{
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	UserService userService;
	
	@Test
	public void testA() {
		
	}

}
