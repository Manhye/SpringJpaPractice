package com.example.springjpapractice.repository;


import com.example.springjpapractice.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findMemberByUsername(String username);

    default Member findMemberByUsernameOrElseThrow(String username){
        return findMemberByUsername(username)
                .orElseThrow(()->
                        new ResponseStatusException(
                                HttpStatus.NO_CONTENT,
                                "Id does not exist. Id = " + username
                        )
                );
    }


    default Member findByIdOrElseThrow(Long id){
        return findById(id)
                .orElseThrow(()->
                        new ResponseStatusException(
                                HttpStatus.NO_CONTENT,
                                "Id Does Not exist. id = " + id
                        )
                );
    }

}
