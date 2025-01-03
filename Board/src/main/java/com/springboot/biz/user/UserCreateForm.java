package com.springboot.biz.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {

	@Size(min = 3, max = 25)
	@NotEmpty(message = "사용자 이름을 입력하세요")
	private String username;

	@NotEmpty(message = "password를 입력하세요")
	private String password1;

	@NotEmpty(message = "password 확인을 입력하세요")
	private String password2;

	@NotEmpty(message = "Email을 입력하세요")
	@Email
	private String email;

}
