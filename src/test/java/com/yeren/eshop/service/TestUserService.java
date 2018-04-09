package com.yeren.eshop.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yeren.eshop.mode.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context-test.xml")
public class TestUserService {
	
	@Autowired
	UserService userService;
	
	@Test
	public void testMakeUser() {
		for(int i=0;i<100000;i++){
			User user=new User();
			user.setUserName("liubiao"+(i+1));
			user.setPassword("123456");
			user.setMobile("18217543800");
			user.setAddress("中囯上海");
			user.setLogin(0);
			user.setSeckill(0);
			boolean result = userService.save(user);
		}
		System.out.println("========ok========");
		System.out.println("========ok========");
		System.out.println("========ok========");
	}
	
	
//	@Test
	public void testSave() {
		User user=new User();
		user.setUserId(1);
		user.setUserName("liubiao");
		user.setPassword("123456");
		user.setMobile("18217543801");
		user.setAddress("中囯上海");
		
		boolean result = userService.save(user);
		System.out.println("新增结果："+result);
	}
	
//	@Test
	public void testUpdate() {
		User user = userService.findById(1);
		user.setMobile("18217543800");
		
		boolean result = userService.update(user);
		System.out.println("更新结果："+result);
	}
	
//	@Test
	public void testFindById() {
		User user = userService.findById(1);
		System.out.println("用戶名："+user.getUserName());
	}
	
//	@Test
	public void testDeleteById() {
		boolean delete = userService.delete(1);
		System.out.println("删除结果："+delete);
	}
}
