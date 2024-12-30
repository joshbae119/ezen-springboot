package com.springboot.biz.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {

	@NotEmpty(message = "제목 입력하세요")
	@Size(max = 200)
	private String subject;

	@NotEmpty(message = "내용 입력하세요")
	private String content;
}