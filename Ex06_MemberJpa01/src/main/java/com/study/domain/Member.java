package com.study.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
@Entity(name="MEMBERJPA01")
public class Member {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	
	@Column(name = "create_date")
	private LocalDate createDate;
	
	
}
