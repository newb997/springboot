package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	//requestMapping을 쓰면 get, post 둘 다 알아서 받는다. 
	@RequestMapping(path = { "/" })
	public @ResponseBody String root() throws Exception { // root로 하면 오류날수 있으니 throws Exception
			// @ResponseBody 순수한 문자열로 반환
		return "JSP로 실행";
	}
	
	@RequestMapping(path = { "/test1" })
	public String test1() {
		return "test1";
	}
	
	@RequestMapping("/test2")
	public String test2() {
		return "sub/test2";
	}
	
}
