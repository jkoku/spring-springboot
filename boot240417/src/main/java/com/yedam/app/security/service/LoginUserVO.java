package com.yedam.app.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class LoginUserVO implements UserDetails {
	
	// 생성자 이용
	private UserVO userVO;
	
	public LoginUserVO(UserVO userVO) {
		this.userVO = userVO;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { //getAuthorities 권한가지고오는애. 우리는 현재전부string가져옴 
		List<GrantedAuthority> auth = new ArrayList<>();
		auth.add(new SimpleGrantedAuthority(userVO.getRoleName()));
		return auth;
	}

	@Override
	public String getPassword() {
		return userVO.getPassword();
	}

	@Override
	public String getUsername() {
		return userVO.getLoginId();
	}

	@Override
	public boolean isAccountNonExpired() { // 게정 만료여부 유효기간
		return true; // true가 만료되지않음을 의미
	}
	
	@Override
	public boolean isAccountNonLocked() { // 계정 잠금 여부 *제일많이씀 
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { // 계정 패스워드 만료 여부 *
		return true;
	}

	@Override
	public boolean isEnabled() { // 계정 사용여부
		return true;
	}
	
}
