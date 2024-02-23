package com.study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.domain.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, String> {

	List<Reply> findAllByRefBnoOrderByReplyNoDesc(Long bno);

}
