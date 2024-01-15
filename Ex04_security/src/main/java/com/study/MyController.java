package com.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@RequestMapping("/")
	public @ResponseBody String root() {
		return "Security Welcome";
	}
	
	@RequestMapping("guest/welcome")
	public String welcome3() {
		return "guest/welcome3";
	}
	
	@RequestMapping("member/welcome")
	public String welcome2() {
		return "member/welcome2";
	}
	
	@RequestMapping("admin/welcome")
	public String welcome1() {
		return "admin/welcome1";
	}
	
	// 스프링시큐리티는 getmapping을 받아서 RequestMapping으로 해줘야함   
	@RequestMapping("/login_check") 
	public String loginForm() {
		return "security/loginForm";
	}
	
	
}







