package com.study.service;

import java.util.List;

import com.study.dto.Board;

public interface BoardService {

	List<Board> list(); // List는 객체 ArrayList는 자료형
	Board detailBoard(String no);	//request로 받으면 String으로 넘어오니까..
	int totalRecord();
	int insertBoard(Board board);
	int deleteBoard(String no);
}
