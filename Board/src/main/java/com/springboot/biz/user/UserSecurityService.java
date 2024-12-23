package com.springboot.biz.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

// @Service 애너테이션은 이 클래스가 Spring의 서비스 빈으로 등록됨을 나타냅니다.
@Service

// @RequiredArgsConstructor는 final 또는 @NonNull이 붙은 필드를 매개변수로 받는 생성자를 자동으로 생성합니다.
// 여기서는 userRepository를 주입받는 생성자가 자동으로 생성됩니다.
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {

	// UserRepository는 데이터베이스와 상호작용하여 사용자 정보를 조회하는 역할을 합니다.
	private final UserRepository userRepository;

	/**
	 * Spring Security에서 인증을 처리할 때 호출되는 메서드. 사용자 이름(Username)을 통해 사용자 정보를 로드하고
	 * 반환합니다.
	 * 
	 * @param username 사용자 이름 (로그인 ID)
	 * @return UserDetails Spring Security의 사용자 인증 정보를 포함하는 객체
	 * @throws UsernameNotFoundException 사용자를 찾을 수 없을 경우 발생
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 데이터베이스에서 사용자 이름으로 사용자 정보를 조회
		Optional<SiteUser> _siteUser = this.userRepository.findByUsername(username);

		// 사용자가 존재하지 않을 경우 UsernameNotFoundException을 던집니다.
		if (_siteUser.isEmpty()) {
			throw new UsernameNotFoundException("사용자를 찾을 수 없습니다");
		}

		// Optional에서 SiteUser 객체를 꺼냅니다.
		SiteUser siteUser = _siteUser.get();

		// 사용자 권한 목록을 저장할 리스트 생성
		List<GrantedAuthority> authorities = new ArrayList<>();

		// "admin" 사용자 이름을 가진 경우 관리자 권한 부여
		if ("admin".equals(username)) {
			// ADMIN 권한 추가
			authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
		} else {
			// 일반 사용자(USER) 권한 추가
			authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
		}

		// Spring Security에서 제공하는 UserDetails 인터페이스의 구현체인 User 객체 생성
		// SiteUser의 사용자 이름, 비밀번호, 권한 목록을 매개변수로 전달
		return new User(siteUser.getUsername(), siteUser.getPassword(), authorities);
	}
}