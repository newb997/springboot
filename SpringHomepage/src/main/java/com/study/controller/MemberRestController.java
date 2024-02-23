package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.domain.Member;
import com.study.dto.ResponseDto;
import com.study.dto.UserDto;
import com.study.service.MemberRestService;

import lombok.extern.slf4j.Slf4j;

// @Controller로 해줄거면 @responseBody도 걸어줘야함 
@RestController
@Slf4j
@RequestMapping("/rest")
public class MemberRestController {
	
	@Autowired
	MemberRestService memberRestService;
	
	@GetMapping("/test")
	public String test() {
		System.out.println("test");
		log.info("test");  // @Slf4j
		return "test";
	}
	
	@GetMapping("/user")
	public String getMember(@RequestParam(value = "empNo", defaultValue = "뭘봐") String empNo) {
		log.info("empNo : {}", empNo);
		System.out.printf("empNo : %s", empNo);
		System.out.println("구파9식");
		
		return "ok : " + empNo;
	}
	
	@GetMapping("/user/{id}")
	public String getMemberId(@PathVariable("id") String id) {
		log.info("id : {}", id);
		return "ok : " + id;
	}
	
	// post로 보내면 http프로토콜 안에 넣어서 보내준다
	// http프로토콜 안에 넣어줄 수 없기 떄문에 test용으로 실행해 볼 수 있음
	/*
	  	1. postman 사용 ( 설치해서 사용 )
	  	2. webmvc 사용 ( https://mvnrepository.com/ 에서 검색해서 build.gradle에 설정하여 사용 )
	  					(검색 결과 : SpringDoc OpenAPI Starter WebMVC UI)
	  		사용방법 : 웹브라우저에서 url 맨 뒤에 swagger-ui.html 붙임(http://localhost:8080/swagger-ui.html)
	 */
	@PostMapping("/userpost")
	public String saveItem(@RequestBody String item) {
		log.info("item : {}", item);
		return "ok : " + item;
	}
	
	/*
	 	json으로 아래와 같은 형태로 받고 싶을 때
	 	dto 클래스를 만들어 객체에 담아 return
	 	
	 		{
	 			"id": "user01",
	 			"name": "홍길동"
	 		}
	 
	@PostMapping("/userdto")
	public UserDto saveUserDto(@RequestBody UserDto userDto) {
		Member m = service.saveUserDto(userDto);
		
		// 생성자의 인자(String id, String name)
		UserDto reDto = new UserDto(m.getId(), m.getName());
		
		// 생성자의 인자(Member m)
		// UserDto reDto = new UserDto(m);
		
		// 위에것을 줄이면
		UserDto reDto = new UserDto(memberRestService.saveUserDto(userDto)); 
		return reDto;
		
		// 위에것을 한줄로 줄이면
		return new UserDto(memberRestService.saveUserDto(userDto));
	}
	*/
	
	@PostMapping("/userdto")
	public ResponseDto saveUserDto(@RequestBody UserDto userDto) {
		Member m = memberRestService.saveUserDto(userDto);
		ResponseDto responseDto = new ResponseDto();
		if(m.getId() != null) {
			responseDto.setMessage("ok");
			return responseDto;
		}
		responseDto.setMessage("fail");
		return responseDto;
	}
	
	// http:localhost:8080/rest/userDto?id=3
	@GetMapping("/userdto")
	public UserDto getUserDto(@RequestParam("id") String id) {
		return memberRestService.getUserById(id);
	}
	
	// http:localhost:8080/rest/userDto?id=3
	@GetMapping("/userDto/{id}")
	public UserDto getUserDto2(@PathVariable("id") String id) { 
		return memberRestService.getUserById(id);
	}
	
	@GetMapping("/userAll")
	public List<Member> getUserAll() {
		return memberRestService.getUserAll();
	}
	
	@GetMapping("/userDtoAll")
	public List<UserDto> getUserDtoAll() {
		return memberRestService.getUserDtoAll();
	}
}















