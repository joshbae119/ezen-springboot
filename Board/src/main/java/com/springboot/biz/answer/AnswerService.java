package com.springboot.biz.answer;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.biz.DataNotFoundException;
import com.springboot.biz.question.Question;
import com.springboot.biz.user.SiteUser;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AnswerService {

	private final AnswerRepository answerRepository;
	
	public void delete(Answer answer) {
		this.answerRepository.delete(answer);
	}

	public void modify(Answer answer, String content) {
		answer.setContent(content);
		this.answerRepository.save(answer);
	}

	public void create(Question question, String content, SiteUser author) {
		Answer answer = new Answer();
		answer.setContent(content);
		answer.setCreateDate(LocalDateTime.now());
		answer.setQuestion(question);
		answer.setAuthor(author);
		this.answerRepository.save(answer);
	}

	public Answer getAnswer(Integer id) {
		Optional<Answer> answer = this.answerRepository.findById(id);
		if (answer.isPresent()) {
			return answer.get();
		} else {
			throw new DataNotFoundException("답변이 존재하지 않습니다.");
		}
	}
}