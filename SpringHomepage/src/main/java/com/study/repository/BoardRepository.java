package com.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.domain.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{

	List<Board> findByTitle(String title);

	List<Board> findByTitleOrContent(String title, String content);

}
