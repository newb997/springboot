package com.study.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor		// 전부있는 생성자
@NoArgsConstructor		// 빈생성자
@Builder				
//@Entity
//@Table(name = "MEMBERJPA01")
//위에 코드를 아래처럼 작성해도 된다.
@Entity(name="MEMBERAM")
@EntityListeners(AuditingEntityListener.class)
public class Member {
	@Id
	private String id;
	private String name;
	private String password;
	
	// 생성되는 시간을 자동으로 넣어줌 (생성될때만 넣는거임 수정일땐 x 수정일땐 @LastModifiedDate )
	@CreatedDate
	@Column(name = " create_date")
	private LocalDate createDate;
	
	// 엔티티가 수정될 때 수정시간을 넣어줌
	@LastModifiedDate
	@Column(name = " update_date")
	private LocalDate updateDate;
	
	/*
	 	@CreatedDate와 @LastModifiedDate를 사용할 때
	 	 - 반드시 @EntityListeners(AuditingEntityListener.class) 달아줘야함. 순서는 상관없음
	 	 - main()메소드가 있는 클래스에도 @EnableJpaAuditing 달아줘야함 여기선Ex09AssociativeMapping.java 파일
	 */
}







