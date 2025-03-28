package com.example.springjpapractice.service;

import com.example.springjpapractice.dto.MemberResponseDto;
import com.example.springjpapractice.dto.SignUpResponseDto;
import com.example.springjpapractice.entity.Member;
import com.example.springjpapractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    public SignUpResponseDto signUp(String username, String password, Integer age) {

        Member member = new Member(username, password, age);

        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getAge());
    }

    public MemberResponseDto findById(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);

        if(optionalMember.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Member Not Found");
        }

        Member findMember = optionalMember.get();
        return new MemberResponseDto(findMember.getUsername(),findMember.getAge());

    }
}
