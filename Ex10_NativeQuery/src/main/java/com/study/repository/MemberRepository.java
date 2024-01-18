package com.study.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.study.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

	// JPQL쿼리 : from 뒤에는 DB테이블이 아니라 영속성에 있는 Entity명. 반드시 대문자로 작성)
	@Query("select m from JPAPAGING m where m.name like :name1 order by m.id desc")  // : 은 ? 를 의미함
										// :name1은 @Param으로 넘어온 이름과 동일하게 작성
	List<Member> findMembers(@Param("name1") String name2);

	
	// 아이디의오름차순
	@Query("select m from JPAPAGING m where m.name like :name1")
	List<Member> findMembers(@Param("name1") String name, Sort sort);

	
	@Query("select m from JPAPAGING m where m.name like :name1")
	Page<Member> findMembers(@Param("name1") String name, Pageable pageable);

	//일반 SQL 쿼리
	@Query(value = "select * from jpapaging where name like :name1 order by id desc", nativeQuery = true)
	List<Member> findMembersNative(@Param("name1") String name);


}
