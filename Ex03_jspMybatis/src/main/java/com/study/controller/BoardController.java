package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.dto.Board;
import com.study.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;	//BoardService 자동으로 의존성주입
	
	@RequestMapping("/")
	public String root() throws Exception{
		return "redirect:list";
	}
	
	/*
		요청 처리 후 응답페이지로 결과를 담는 방법
		1. Model 객체 사용
			- 뷰로 전달하고자 하는 데이터를 맵형식(key=value)로 담을 수 있는객체
			- 기본이 requestScope임
				단, setAttribute가 아닌 addAttribute메소드 이용
		2. ModelAndView 
			- Model 영역에 뷰로 전달하고자 하는 데이터를 맵형식(key=value)로 담을 수 있는객체
			- View 영역은 응답뷰에 대한 정보를 담을 수 있는 공간
			
			ex) public String list(ModelAndView mv) {
					List<Board> rlist = boardService.list();
					mv.addObjdect("boardList", rlist)     <-- key, 값  key이름은 내맘대로 
					mv.setViewName("/list");
					return "mv";
				}
	 */
	@RequestMapping("/list")
	public String list(Model model) {
//		List<Board> rlist = boardService.list();
		model.addAttribute("list", boardService.list());
		model.addAttribute("totalRecord", boardService.totalRecord());
		return "list";
	}
	
	@GetMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	/*
		파라미터(요청시 전달값)를 받는방법
		1. HttpServletRequest를 이용하여 전달받기(기존 jsp/servlet때의 전달방식) / jsp에서 사용함
		2. @RequestParam 어노테이션을 이용하는 방법
		   @RequestParam("")
		   - 속성
		   	 value = uri에서 바인딩하게 될 값
		   	 required(true|false) : 필수적으로 값이 전달되게 되는지 안받아도 되는지(true일때 값이 안들어오면 에러)
		   	 defaultValue : 값이 없을 때 기본값으로 사용할 값
		   	 
		   	 - @RequestParam("전달된 name(key값)") 변수명 : defaultValue를 안넣을 때는 value는 생략가능
		   	 - ex) @RequestParam(value="key", [defaultValue="", required=true]) 자료형 변수명
		   	 	   @RequestParam("key")
		3. 커맨드 객체 방식
		   dto클래스에 담는 방식
		   요청시 전달값의 키(name)을 dto클래스에 담고자 하는 필드명을 작성
		   
		   스프링컨테이너가 해당 객체를 기본생성자를 생성 후 setter메소드를 찾아서 전달된 값을 해당필드에 내부적으로 담아주는 원리
		   - 반드시 기본생성자가 필요함
		   - setter메소드가 필요함
		   - key 이름이 필드명과 같아야 됨
	 */
	@PostMapping("/write")
	public String write(Board board) {
//		System.out.println("제목 : " + board.getTitle());
//		System.out.println("작성자 : " + board.getWriter());
//		System.out.println("내용 : " + board.getContent());
		
		boardService.insertBoard(board);
		return "redirect:list";	// redirect를 안해주면 주소창에 /write 나옴 forward형식
	}
	
	@GetMapping("/detail")
	public String detailBoard(HttpServletRequest request, Model model) {
		String no = request.getParameter("no");
//		System.out.println("no : " + request.getParameter("no"));
		Board board = boardService.detailBoard(request.getParameter("no"));
		model.addAttribute("dBoard", board);
		return "detailForm";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam(value = "no", defaultValue = "1") String bno) {
		boardService.deleteBoard(bno);
		
		return "redirect:list";
	}
	
}











