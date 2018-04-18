package com.yeren.seckill.execute;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yeren.seckill.mode.User;
import com.yeren.seckill.service.UserService;

/**
 * 创建用户
 * @author ThinkPad
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context-test.xml")
public class SaveUserToMysqlExecute {
	
	@Autowired
	UserService userService;
	
	@Test
	public void saveUser() {
		for(int i=0;i<12345;i++){
			User user=new User();
			user.setUserName("liubiao"+(i+1));
			user.setPassword("123456");
			user.setMobile("18217543800");
			user.setAddress("");
			
			//对3取余为0的用户是在线的
			if(i%3==0){
				user.setLogin(1);
				//对3取余为0的用户是在线的,并且这些人中对4取余的人是要参与秒杀的
				if(i%4==0){
					user.setSeckill(1);
				}else{
					user.setSeckill(0);
				}
			}else{
				user.setLogin(0);
				user.setSeckill(0);
			}
			boolean result = userService.save(user);
		}
		System.out.println("========ok========");
		System.out.println("========ok========");
		System.out.println("========ok========");
	}

}
