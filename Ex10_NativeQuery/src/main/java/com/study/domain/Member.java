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
@Entity(name="JPAPAGING")
public class Member {
	@Id
	@SequenceGenerator(
				name = "mySequence",				// 시퀀스의 고유한이름
				sequenceName = "JPAPAGING_SEQ",		// 실제 DB에서의 시퀀스명
				initialValue = 1,					// 초기값
				allocationSize = 1					// 1씩 증가
			)
	
	@GeneratedValue(generator = "mySequence")
	private Long id;
	private String name;
	private String email;

}
