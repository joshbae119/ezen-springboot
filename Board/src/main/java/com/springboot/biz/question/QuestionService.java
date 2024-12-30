package com.springboot.biz.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springboot.biz.DataNotFoundException;
import com.springboot.biz.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService { 
	private final QuestionRepository questionRepository;

	public void vote(Question question, SiteUser siteuser) {
		question.getVoter().add(siteuser);
		this.questionRepository.save(question);
	}

	public void delete(Question question) {
		this.questionRepository.delete(question);
	}

	public void modify(Question question, String subject, String content) {
		question.setSubject(subject);
		question.setContent(content);
		question.setModifyDate(LocalDateTime.now());
		this.questionRepository.save(question);
	}

	public void create(String string, String content, SiteUser user) {
		Question q = new Question();
		q.setSubject(string);
		q.setContent(content);
		q.setCreateDate(LocalDateTime.now());
		q.setAuthor(user);
		this.questionRepository.save(q);
	}

	public Page<Question> getList(int page) {
		List<Sort.Order> sorts = new ArrayList<>();
		sorts.add(Sort.Order.desc("createDate"));
		Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
		return this.questionRepository.findAll(pageable);
	}

	public Question getQuestion(Integer id) {
		Optional<Question> question = this.questionRepository.findById(id);
		if (question.isPresent()) {
			return question.get();
		} else {
			throw new DataNotFoundException("질문이 존재 하지 않습니다.");
		}
	}
}