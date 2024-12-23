package com.springboot.biz.user;

import lombok.Getter;

@Getter
public enum UserRole {

	ADMIN("ROLE_ADMIN"), USER("ROLE_USER");

	private UserRole(String value) {
		this.value = value;
	}

	private String value;

}
