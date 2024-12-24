package com.springboot.biz.question;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

	Page<Question> findAll(Pageable Pagaable);

	// SELECT * FROM QUESTION WHERE subject = ?
	Question findBySubject(String subject);

	// Question findById(int id);

	// OR > findBySubjectOrContent ㅇㅇ
	Question findBySubjectAndContent(String subject, String content);

	List<Question> findBySubjectLike(String subject);
}