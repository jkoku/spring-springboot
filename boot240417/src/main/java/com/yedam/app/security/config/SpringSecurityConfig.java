package com.yedam.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 트랜잭션매니저
public class SpringSecurityConfig {
	// Password 암호화를 처리하는 빈
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // BCryptPasswordEncoder 해쉬. 통해서 암호화작업처리.
	}
	
	// 원래 개발할때 사용하지않음. 내부의 코드를 넣어두고 간단한 테스트할때 종종사용
	// 메모리상 인증정보 활용
	//@Bean // 클라우드형태로 저장되명 오픈되고 보안상문제있어서 db사용할거라서 막아둠. 
	public InMemoryUserDetailsManager InMemoryUserDetailsService() {
		UserDetails user = User.builder()
								.username("user1")
								.password(passwordEncoder().encode("1234"))
								.roles("USER", "SALES")
								// .authorities("ROLE_USER")
								.build();
		return new InMemoryUserDetailsManager(user);
	}
	
	// 인증 및 인가 설정
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		//실제정보들 들어가고 빌드된게 체인한테 넘겨짐
		http.authorizeHttpRequests() //인가부분 등록 필터가 체크해야되는 인증, 인가에 대해서 어느 url에 사용할건지에 대한 정의 . 
					.antMatchers("/","/all").permitAll() // 등록방식   permitAll인증받지않은 모든사람에 대한 접근을 허용하는 메소드.
					.antMatchers("/user/**").hasAnyRole("USER","ADMIN") //ROLE_USER
					.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
					.anyRequest().authenticated() //AnyRequest 통쨰로 처리간으.  authenticated 인증된 대상에대해서만 접근
				.and()
				.formLogin()
					.defaultSuccessUrl("/all")
				.and()
				.logout()
					.logoutSuccessUrl("/all");
			
		//http.csrf();
		//http.csrf().disable();
			
		return http.build();	
		
		/*http.formLogin() // 내장된 방식 그대로 쓰겟다는 선어.선언. 선언을 하지않으면 기존의 내장된것을 사용할텐데 새로운거 사용한다고 선언해서. 
			.defaultSuccessUrl("/all"); // 사용하고자하는거  이 안에 선언.
										
		http.logout();
		http.csrf().disable();
		
		return http.build(); http.formLogin은구분해서 하는 방식, 위에 and는 build?이어하는 방식*/ 
		
	}
	
}

