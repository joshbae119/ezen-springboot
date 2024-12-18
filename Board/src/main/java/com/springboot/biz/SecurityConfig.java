package com.springboot.biz;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration    //스프링 환경 설정 파일
@EnableWebSecurity   //모든 URL 요처을 스프링 시큐리티의 제어를 받도록 설정 시큐리티 활성화
public class SecurityConfig {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
				.requestMatchers(new AntPathRequestMatcher("/**")).permitAll());
		
		//authorizeHttpRequests: 특정경로에 대한 연결 설정
		//requestMatchers: 특정 경로의 요청에 대한 연결 허용
		//AntPathRequestMatcher: 특정 경로를 설정
		//permitAll: 누구나 접근이 가능하게 설정
		return http.build();
	}

}