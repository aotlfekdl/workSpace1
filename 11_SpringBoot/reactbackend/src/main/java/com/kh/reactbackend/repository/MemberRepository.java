package com.kh.reactbackend.repository;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    void save(Member member);
    Optional<Member> findOne(String userId);
    void delete(Member member);
    List<Member> findAll();
    List<Member> findByName(String name);
    void isDeleted(Member member);
    Optional<Member> findByIdandPwd(String userId, String userPwd);
}
