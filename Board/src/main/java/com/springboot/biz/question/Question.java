package com.springboot.biz.question;

import java.time.LocalDateTime;
import java.util.List;

import com.springboot.biz.answer.Answer;
import com.springboot.biz.user.SiteUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Setter // Lombok 어노테이션: 필드의 Setter 메서드를 자동으로 생성
@Getter // Lombok 어노테이션: 필드의 Getter 메서드를 자동으로 생성
@Entity // JPA 어노테이션: 이 클래스가 데이터베이스 테이블과 매핑된 엔티티임을 나타냄
public class Question {

	@Id // 기본 키(primary key)로 사용될 필드
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// 기본 키 값을 자동 생성하도록 설정 (IDENTITY: 데이터베이스에서 AUTO_INCREMENT 사용)
	private Integer id; // 질문의 고유 ID (기본 키)

	@Column(length = 200)
	// subject 컬럼의 최대 길이를 200자로 제한
	private String subject; // 질문 제목

	@Column(columnDefinition = "TEXT")
	// content 컬럼을 TEXT 타입으로 설정 (긴 텍스트 데이터 저장 가능)
	private String content; // 질문 내용

	private LocalDateTime createDate;
	// 질문 생성 날짜와 시간을 저장하는 필드

	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	// 질문(Question)과 답변(Answer) 간의 1:N 관계를 설정
	// mappedBy: Answer 엔티티의 question 필드와 연결
	// cascade = CascadeType.REMOVE: 질문이 삭제되면 연관된 답변들도 함께 삭제
	private List<Answer> answerList;
	// 질문에 달린 답변들을 저장하는 리스트

	@ManyToOne
	private SiteUser author;

	// 수정 시간
	private LocalDateTime modifyDate;
}