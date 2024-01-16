package exam1;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity
public class Member1 {
	@Id			// 필수 : primary key
	@GeneratedValue		// 자동증가, 시퀀스 사용하는것과 동일
	private Long id;	// int로 했을 시 null값이 등러오면 0으로 오류가 안뜨지만 Long으로 하면 오류가 뜨기 때문에 Long을 써줌
	private String username;
	
	/* 
	   @Column 에서 사용하는 속성
	   - name : 컬럼이름 지정(생략시 변수명과 동일하게 매핑)
	   - unique : unique제약조건 추가( 기본값 : false )
	   - nullable : null상태 허용 여부( 기본값 : false )
	   - insertable : insert를  할 때 이 컬럼을 포함할 것인지 말건지 결정 ( 기본값 : true ) 이거 포함 안함
	   - updateable : update를  할 때 이 컬럼을 포함할 것인지 말건지 결정 ( 기본값 : true ) 이거만 빼고 업데이트
	   - length : 문자열 타입의 컬럼의 길이 지정( 기본값 : 255 )
	   - columnDefinition : 컬럼에 대한 ddl문을 직접 기술할 수 있음  ex) @Column(columnDefinition = "varchar2(200)" default 'kk'")
	 */
	@Column(name = "create_date")
	
	/* 
	 	LocalDateTime
	 	
	 	 @Temporal(TemporalType.TIMESTAMP)
	 */
	private LocalDate createDate;	// @Column(name = "create_date") : dto에서는 createDate로 쓸건데 DB에넣을때는 create_date 형식으로 넣겠다.

	
	
	public Member1() {}	// 필수

	public Member1(String username, LocalDate createDate) {
		this.username = username;
		this.createDate = createDate;
	}
}














