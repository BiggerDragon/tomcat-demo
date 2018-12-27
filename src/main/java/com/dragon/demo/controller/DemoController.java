package com.dragon.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DemoController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("DemoController...");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("JsonView");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "This is DemoController");
		mav.addAllObjects(map);
		return mav;
	}
	
	

}
