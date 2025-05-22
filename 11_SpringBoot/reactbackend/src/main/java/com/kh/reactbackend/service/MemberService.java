package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.entity.Member;

import java.util.List;

public interface MemberService {
    String createMember(MemberDto.Create createDto);
    MemberDto.Response findMember(String userId);
    MemberDto.Response updateMember(String userId, MemberDto.Update updateDto);
    void deleteMember(String userId);
    List<MemberDto.Response> findAllMember();
    List<MemberDto.Response> findByName(String name);
    void isDeletedMember(String userId);
    Member loginMember(MemberDto.login loginDto);
}
