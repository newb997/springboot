package com.study.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;



@Configuration
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		// 람다형태 : request -> request (security 7.0부터 람다식만 가능)
		// 람다는 화살표임
		// http.csrf().disable() 에서 바뀜
		http.csrf((csrf)-> csrf.disable())
			.cors((cors)-> cors.disable())
			.authorizeHttpRequests(request -> request
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll() // permitAll() : 모두 허용
				.requestMatchers("/").permitAll()
				.requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
				.requestMatchers("/guest/**").permitAll()
				.requestMatchers("/member/**").hasAnyRole("USER", "ADMIN")		// hasAnyRole() : 여러 권한주기. 권한 나누기 / 보통 대문자로 많이함 
				.requestMatchers("/admin/**").hasRole("ADMIN")	// hasRole() : 하나에게만 권한. 보통 / 대문자로 많이함
				.anyRequest().authenticated() //authenticated() : 
			);
		
		// 스프링부트에서 제공해주는 기본 login, logout폼 사용
//		http.formLogin((formLogin)-> 
//						formLogin.permitAll());		
		
		// 내가 만든 login폼 사용하기
		http.formLogin((formLogin)-> formLogin
							.loginPage("/loginForm")		// 로그인 폼 url(default : /login)   jsp 페이지 이름
							.loginProcessingUrl("/login_check")		// controller에 있는 경로 action 이름
							.usernameParameter("username") 		// jsp input name    기본값은  (j_username)
							.passwordParameter("password") 		// jsp input name    기본값은  (j_password)
							.permitAll());
		
		http.logout((logout)-> logout
							.logoutUrl("/logout")
							.logoutSuccessUrl("/")
							.permitAll());
					 
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
							   .username("user")
							   .password(pEncoder().encode("1234"))
							   .roles("USER")
							   .build();
		UserDetails admin = User.builder()
							   .username("admin")
							   .password(pEncoder().encode("1234"))
							   .roles("USER", "ADMIN")
							   .build();
		
		// 메모리에 사용자 정보를 담는다
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	public PasswordEncoder pEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}


















