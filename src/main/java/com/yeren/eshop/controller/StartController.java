package com.yeren.eshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yeren.eshop.mode.User;
import com.yeren.eshop.service.GoodsService;
import com.yeren.eshop.service.UserService;

import net.sf.json.JSONArray;
@Controller
@RequestMapping("/a")
public class StartController {
	@Autowired
	GoodsService goodsService;
	
	@Autowired
	UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(StartController.class);
	
	
	@RequestMapping(value="/makeUser", method = RequestMethod.GET)
	@ResponseBody
	public JSONArray makeUser(HttpServletRequest request, HttpServletResponse response){
		
		for(int i=0;i<10;i++){
			User user=new User();
			user.setUserName("liubiao"+i);
			user.setPassword("123456");
			user.setMobile("18217543801");
			user.setAddress("中囯上海");
			user.setSeckill(0);
			boolean result = userService.save(user);
		}
		
		JSONArray jsonArray=new JSONArray();
		jsonArray.add("count:"+"");
		return jsonArray;
	}
}
