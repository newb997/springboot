package com.study.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.domain.Member;
import com.study.dto.UserDto;
import com.study.repository.MemberRepository;
@Service
public class MemberRestService {
	
	@Autowired
	MemberRepository memberRepository;

	public Member saveUserDto(UserDto userDto) {
		Member member = new Member();
		member.setId(userDto.getId());
		member.setPassword("123");
		member.setName(userDto.getName());
		
		return memberRepository.save(member);
	}


	public UserDto getUserById(String id) {
		
//		Member m = repository.findById(id).get(); // 이렇게 하거나 	/ .get()  -->  optional 벗김
//		//Optional<Member> m = repository.findById(id); Optional로 하거나 
//		UserDto userDto = new UserDto();
//		userDto.setName(m.getName());
		
		return new UserDto(memberRepository.findById(id).get());
	}


	public List<Member> getUserAll() {
		return memberRepository.findAll();
	}


	public List<UserDto> getUserDtoAll() {
		// List<Member> mList = memberRepository.findAll();
				List<UserDto> uList = new ArrayList<>();
				for(Member m : memberRepository.findAll()) {
					uList.add(new UserDto(m));
				}
				return uList;
	}

}
