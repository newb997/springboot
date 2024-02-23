package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.domain.Reply;
import com.study.service.BoardService;
import com.study.service.ReplyService;

@Controller
public class ReplyController {

	@Autowired
	BoardService boardService;
	
	@Autowired
	ReplyService replyService;
	
	@ResponseBody
	@PostMapping("rinsert")
	public String insertReply(@RequestParam(value = "boardNo") int boardNo,
							  @RequestParam(value = "writer") String loginUserId,
							  @RequestParam(value = "content") String replyContent, 
							  Reply reply) {
		
		reply.setRefBno(boardNo);
		reply.setReplyWriter(loginUserId);
		reply.setReplyContent(replyContent);
		
		replyService.insertReply(reply);
		
		return "success";
	}
}
