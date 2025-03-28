package com.example.springjpapractice.repository;


import com.example.springjpapractice.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
