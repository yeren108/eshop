package com.yeren.controller;

import com.yeren.redis.RedisCacheDao;
import com.yeren.mode.User;
import com.yeren.service.GoodsService;
import com.yeren.service.UserService;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/start")
public class StartController {
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RedisCacheDao redisCacheDao;
	
	
	private static final Logger logger = LoggerFactory.getLogger(StartController.class);
	
	
	@RequestMapping(value="/makeUser", method = RequestMethod.GET)
	@ResponseBody
	public JSONArray makeUser(HttpServletRequest request, HttpServletResponse response) throws Exception{
			System.out.println("---=====");
			User user=new User();
			user.setUserName("liubiao999");
			user.setPassword("123456");
			user.setMobile("18217543802");
			user.setAddress("中囯上海");
			user.setSeckill(0);
			redisCacheDao.putCache("abc", user);
			User cacheUser=null;
			String cache=null;
				cacheUser = (User)redisCacheDao.getCache("abc");
				cache = (String)redisCacheDao.getCache("liubiao999");
			System.out.println(cacheUser.getUserName());
			
			System.out.println(cache);
		JSONArray jsonArray=new JSONArray();
		jsonArray.add("count:"+"");
		return jsonArray;
	}
}
