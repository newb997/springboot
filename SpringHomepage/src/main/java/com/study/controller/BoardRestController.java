package com.study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.domain.Board;
import com.study.repository.BoardRepository;

@RestController
@RequestMapping("/rest")
public class BoardRestController {

	@Autowired
	BoardRepository boardRepositoty;
	
//	@GetMapping("/boards")
//	List<Board> boardAll() {
//		return boardRepositoty.findAll();
//	}
	
//	@GetMapping("/boards")
//	List<Board> boardAll(@RequestParam(value = "title", required=false) String title) {
//		
//		if(title == null) {
//			return boardRepositoty.findAll();
//		}else {
//			return boardRepositoty.findByTitle(title);
//		}
//	}
	
	@GetMapping("/boards")
	List<Board> boardAll(@RequestParam(value = "title", required=false) String title,
						 @RequestParam(value = "content", required=false) String content) {
		if(title == null && content == null) {
			return boardRepositoty.findAll();
		}else {
			return boardRepositoty.findByTitleOrContent(title, content);
		}
	}
	
	//update
	@PutMapping("/boards/{bno}")
	public Board replaceBoard(@RequestBody Board newBoard, @PathVariable("bno") Long bno) {
		return boardRepositoty.findById(bno) //body에서 가져온걸 newBoard에 넣음
							  .map(board -> {
								  board.setTitle(newBoard.getTitle());
								  board.setContent(newBoard.getContent());
								  return boardRepositoty.save(board);		//update
							  })
							  .orElseGet(() -> {
								  newBoard.setBno(bno);
								  return boardRepositoty.save(newBoard);	//insert
							  });
	}
	
	//delete
	@DeleteMapping("/boards/{bno}")
	public void deleteBoard(@PathVariable("bno") Long bno) {
		boardRepositoty.deleteById(bno);
	}
	
	
}











