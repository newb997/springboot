package com.study.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
@Entity(name="MEMBERJPA02")
public class Member {
	@Id
	@SequenceGenerator(
				name = "MEMBERJPA02",				// 시퀀스의 고유한이름
				sequenceName = "MEMBERJPA02_SEQ",	// 실제 DB에서의 시퀀스명
				initialValue = 1,	
				allocationSize = 1	
			)
	
	@GeneratedValue(generator = "MEMBERJPA02")
	private Long id;
	private String name;
	private String email;
	
	public Member(String email, String name) {
		this.name = name;
		this.email = email;
	}
	
	
	
}
