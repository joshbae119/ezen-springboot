package com.springboot.biz.answer;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnswerForm {

	@NotEmpty(message = "내용은 반드시 입력 하셔야 합니다.")
	public String content;

}
