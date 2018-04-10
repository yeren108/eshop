package com.yeren.seckill.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yeren.seckill.mode.User;
import com.yeren.seckill.service.GoodsService;
import com.yeren.seckill.service.RedisCache;
import com.yeren.seckill.service.UserService;

import net.sf.json.JSONArray;
@Controller
@RequestMapping(value="/start")
public class StartController {
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RedisCache redisCache;
	
	
	private static final Logger logger = LoggerFactory.getLogger(StartController.class);
	
	
	@RequestMapping(value="/makeUser", method = RequestMethod.GET)
	@ResponseBody
	public JSONArray makeUser(HttpServletRequest request, HttpServletResponse response){
			System.out.println("---=====");
			User user=new User();
			user.setUserName("liubiao999");
			user.setPassword("123456");
			user.setMobile("18217543802");
			user.setAddress("中囯上海");
			user.setSeckill(0);
			try {
				redisCache.putCache("abc", user);
				redisCache.putCache("name", "liubiao999");
			} catch (Exception e) {
				e.printStackTrace();
			}
			User cacheUser=null;
			String cache=null;
			try {
				cacheUser = (User)redisCache.getCache("abc");
				cache = (String)redisCache.getCache("liubiao999");
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(cacheUser.getUserName());
			
			System.out.println(cache);
		JSONArray jsonArray=new JSONArray();
		jsonArray.add("count:"+"");
		return jsonArray;
	}
}
