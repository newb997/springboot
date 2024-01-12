package com.study.dto;

import lombok.Data;
import lombok.NonNull;

//@Getter
//@Setter
//@RequiredArgsConstructor
//@ToString
//@EqualsAndHashCode
//위에 다섯개 합친게 @Data


//@Data
/* 
	생성자 1개만 생서됨
 	- @NonNull이 붙어있는 필드만 매개변수로한 생성자가 생성됨
 	- @NonNull이 하나도 없을때는 매개변수가 없는 생성자가 생성됨
 */


//@NoArgsConstructor
//@AllArgsConstructor
@Data
public class Board {
	
	@NonNull	// null값을 가질 수 없다 null이면 exception발생
	private int no;
	private String title;
	private String writer;
	@NonNull
	private String content;
}
