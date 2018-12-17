package com.yeren.controller;

import com.yeren.bean.Link;
import com.yeren.bean.User;
import net.sf.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StartController {

	private static final Logger logger = LoggerFactory.getLogger(StartController.class);


	@RequestMapping(value="/hello", method = RequestMethod.GET)
	@ResponseBody
	public JSONArray hello(HttpServletRequest request, HttpServletResponse response) throws Exception{

		JSONArray jsonArray=new JSONArray();
		jsonArray.add("===:"+"hello");
		return jsonArray;
	}

	@RequestMapping(value="/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return "index";
	}

	@RequestMapping(value = "/zrjd",method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView zrjd() throws Exception {
		ModelAndView mv = new ModelAndView();

		Link link1 = new Link("baidu","https://www.baidu.com");
		Link link2 = new Link("tencent","www.qq.com");
		Link link3 = new Link("ali","www.ali.com");
		Link link4 = new Link("jd","www.jd.com");
		Link link5 = new Link("douyu","www.douyu.com");

		List<Link> list = new ArrayList<Link>();
		list.add(link1);
		list.add(link2);
		list.add(link3);
		list.add(link4);
		list.add(link5);

		mv.addObject("links", list);
		mv.setViewName("zhurijiangdao");
		return mv;
	}

	@RequestMapping(value = "/testFreemarker")
	@ResponseBody
	public ModelAndView testFreemarker(@RequestParam(value = "a", required = false) String a) throws Exception {
		ModelAndView mv = new ModelAndView();

		User user = new User("may", 21);

		List<String> list = new ArrayList<String>();
		list.add("Jack1");
		list.add("Jack2");
		list.add("Jack3");

		mv.addObject("dog", list);
		mv.addObject("user", user);
		mv.addObject("param", new String(a.getBytes("iso8859-1"), "utf-8"));
		mv.setViewName("may");
		return mv;
	}
}


