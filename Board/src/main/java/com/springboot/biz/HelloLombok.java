package com.springboot.biz;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloLombok {

	private final String hello;
	private final int lombok;

	public static void main(String[] args) {
		HelloLombok he = new HelloLombok("박지영", 200);

		System.out.println(he.getHello());
		System.out.println(he.getLombok());

	}

}
