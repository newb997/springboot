package com.study.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/insert")
	public String insert(@RequestParam("username") String username, Model model)  {	// 하나만 들어오면 value = "username" 생략해도됨
			
		// 나에게 맞는 생성자를 만드는 용도로 사용
		Member member = Member.builder()
							  .username(username)
							  .createDate(LocalDate.now())
							  .build();		// .build(); 이 메소드를 이용해서 객체를 생성. 생성자를 만들지 않고도 사용 가능하다
											// builder를 이용하여 생성자를 대체해서 사용하면 가독성이 좋아진다
		Member result = memberService.insert(member);
		model.addAttribute("member", result);
		
		return "insert";
		
		
	}
	@GetMapping("/select")
	public String select(@RequestParam("id") Long id, Model model) {
		Optional<Member> result = memberService.select(id);
		
		// .get().  :  Optional을 벗겨줘야한다
//		result.get().getUsername();
//		result.get().getId();
		
		// 받을때 Wrapping을 벗겨줘도 된다
//		Member member = memberService.select(id).get();
		// isPresent() : 데이터가 있는지 없는지 체크
		if(result.isPresent()) {
			model.addAttribute("member", result.get());	// .get()으로 벗겨주면 Member형으로 넘겨줌
//			model.addAttribute("m", member);
		} else {
			model.addAttribute("member", null);
		}
		return "select";
	}
	
	@GetMapping("/selectAll")
	public String selectAll(Model model) {
		model.addAttribute("members", memberService.selectAll());
		return "selectAll";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") Long id) {
		memberService.delete(id);
		return "redirect:selectAll";
	}
	
	@GetMapping("/update")
	public String update(Member member, Model model) {	// entity의 이름과 일치하면 ㅆ
		model.addAttribute(memberService.update(member));
		
		return "update";
	}
	
}









