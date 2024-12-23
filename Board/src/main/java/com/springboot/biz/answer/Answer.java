package com.springboot.biz.answer;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;

import com.springboot.biz.question.Question;
import com.springboot.biz.user.SiteUser;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@CreatedDate	
	private LocalDateTime createDate;
	
	@ManyToOne
	private Question question;
	
	@ManyToOne
	private SiteUser author;
	
	private LocalDateTime modifyDate;

}
