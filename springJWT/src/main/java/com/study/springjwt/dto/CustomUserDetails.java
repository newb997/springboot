package com.study.springjwt.dto;

import com.study.springjwt.domain.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private  final UserEntity userEntity;

    public CustomUserDetails(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    // roll값 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return userEntity.getRole();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userEntity.getUsername();
    }

    // 계정이 만료되지 않았는지(true:만료되지 않음, false:만료)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠김여부(true:잠겨있지 않음, false:잠김)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 계정의 패스워드가 만료되지 않았는지(true:만료되지 않음)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정이 사용 가능한 계정인지(true:사용 가능한 계정)
    @Override
    public boolean isEnabled() {
        return true;
    }
}
