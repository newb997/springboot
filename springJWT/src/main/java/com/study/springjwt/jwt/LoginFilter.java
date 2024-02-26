package com.study.springjwt.jwt;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    // 검증 담당
    private final AuthenticationManager authenticationManager;

    // 생성자
    public LoginFilter(AuthenticationManager authenticationManager/*, JwtUtil jwtUtil*/) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        // 클라이언트 요청에서 username, password추출
        String username = obtainUsername(request);      // request에서 사용자이름을 가져오는 메소드
        String password = obtainPassword(request);      // request에서 비밀번호를 가져오는 메소드

        // 스프링 시큐리티에서 username, password를 검증하기 위해 token에 담아야 함
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password, null);

        // toden 에 담은 검증을 위한 authenticationManager로 전달
        return authenticationManager.authenticate(authenticationToken);
    }

    // 로그인 성공시 실행하는 메소드(실제 jwt를 발급하면 됨)


    // 로그인 실패시 실해하는 메소드
}