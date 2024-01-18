package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.domain.Member;
import com.study.service.MemberService;



@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@RequestMapping("/")
	public String root() throws Exception {
		return "menu";
	}
	
	@GetMapping("/selectByNameLike1")
	public String selectMembers1(@RequestParam("name") String search, Model model) {
		String name = search + "%";
		model.addAttribute("members", memberService.selectMembers1(name));
		
		return "select_name_list1";
	}
	
	@GetMapping("/selectByNameLike2")
	public String selectMembers2(@RequestParam("name") String search, Model model) {
		String name = search + "%";
		Sort sort = Sort.by(Sort.Order.asc("id"));
		model.addAttribute("members", memberService.selectMembers2(name, sort));
		
		return "select_name_list1";
	}
	
	
	
	@GetMapping("/selectByNameLike3")
	public String selectMembers3(@RequestParam("name") String search,
								   @RequestParam("page") int page,
								   Model model) {
		String name = search + "%";			//user%
		Sort sort = Sort.by(Sort.Order.desc("name"));
		int nPage = page - 1;			// JPA에서 paging은 1페이지가 0부터 시작
		
		Pageable pageable = PageRequest.ofSize(10).withPage(nPage).withSort(sort);  // .ofSize() : 한 페이지당 몇개 보여줄꺼냐?  여기서는 10개
		
		Page<Member> result = memberService.selectMembers3(name, pageable);
		List<Member> content = result.getContent();
		long totalElements = result.getTotalElements();
		int totalPages = result.getTotalPages();
		int size = result.getSize();				// 한 페이지당 보여줄 갯수
		int pageNumber = result.getNumber() + 1;	// 현재 페이지. 0부터 시작
		int numberOfElement = result.getNumberOfElements();	//현재페이지의 n 
		
		model.addAttribute("members", content);
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("size", size);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("numberOfElement", numberOfElement);
		
		
		return "select_name_list2";
	}
	
	
	@GetMapping("/selectByNameLike4")
	public String selectMembers4(@RequestParam("name") String search, Model model) {
		String name = search + "%";
		model.addAttribute("members", memberService.selectMembers4(name));
		
		return "select_name_list1";
	}
	
	
	
	
	/*
	public String selectByNameLike1(@RequestParam("name") String search,
			   @RequestParam("page") int page,
			   Model model) {
	*/

}









