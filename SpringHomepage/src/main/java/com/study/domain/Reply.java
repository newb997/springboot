package com.study.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Reply {

	@Id
	@SequenceGenerator(
			name = "myReplySEQ",
			sequenceName = "Reply_SEQ",
			allocationSize = 1
		)
	@GeneratedValue(generator = "myReplySEQ")
	private int replyNo;
	private String replyContent;
	
	// 게시물 번호
	private int refBno;
	
	private String replyWriter;
	private String status;
	
	@CreatedDate
	@Column(name = "create_date")
	private LocalDate replyCreateDate;
	
	@LastModifiedDate
	@Column(name = "update_date")
	private LocalDateTime replyUpdateDate;
	
}
