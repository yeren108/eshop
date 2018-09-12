package com.yeren.service;

import com.yeren.seckill.service.CartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yeren.seckill.mode.Cart;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context-test.xml")
public class TestCartService {
	
	@Autowired
	CartService cartService;
	
	@Test
	public void testSave() {
		Cart cart =new Cart();
		cart.setUserId(1);
		cart.setGoods("(1,5)&");
		cart.setClean(false);
		cart.setPayed(false);
		
		boolean result = cartService.save(cart);
		System.out.println(":"+result);
	}
	
	@Test
	public void testUpdate() {
		Cart cart = cartService.findById(2);
		cart.setGoods("(1,6)&");
		boolean result = cartService.update(cart);
		System.out.println(":"+result);
	}
	
	@Test
	public void testFindById() {
		Cart cart = cartService.findById(2);
		System.out.println(":"+cart.getGoods());
	}
	
	@Test
	public void testDeleteById() {
		boolean delete = cartService.delete(2);
		System.out.println(":"+delete);
	}
}
