package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.entity.Member;
import com.kh.reactbackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    //createDto : 사용자가 입력한 회원정보
    public String createMember(MemberDto.Create createDto) {
        Member member = createDto.toEntity(); //메모리 올라온 member
        memberRepository.save(member);
        return member.getUserId(); // 영속상태의 member
    }

    //
    @Transactional(readOnly = true)
    @Override
    public MemberDto.Response findMember(String userId) {
        return memberRepository.findOne(userId)
                .map(MemberDto.Response::toDto) //있으면 변환해줘.
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
    }

    @Override
    public MemberDto.Response updateMember(String userId, MemberDto.Update updateDto) {
        Member member = memberRepository.findOne(userId)
                                        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        member.updateMemberInfo(
                updateDto.getUser_name(),
                updateDto.getEmail(),
                updateDto.getGender(),
                updateDto.getPhone()

        );
        return MemberDto.Response.toDto(member);
    }

    @Override
    public void deleteMember(String userId) {
        Member member = memberRepository.findOne(userId)
                                        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        memberRepository.delete(member);
    }

    @Override
    public List<MemberDto.Response> findAllMember() {
        return memberRepository.findAll().stream().map(MemberDto.Response::toDto).collect(Collectors.toList());
    }

    @Override
    public List<MemberDto.Response> findByName(String name) {
        return memberRepository.findByName(name).stream().map(MemberDto.Response::toDto).collect(Collectors.toList());
    }

    @Override
    public void isDeletedMember(String userId) {
        Member member = memberRepository.findOne(userId)
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));

        memberRepository.isDeleted(member);

    }

    @Override
    public Member loginMember(MemberDto.login loginDto) {
        String userId = loginDto.getUser_id();
        String userPwd = loginDto.getUser_pwd();

            return memberRepository.findByIdandPwd(userId, userPwd).orElseThrow(() -> new RuntimeException("아이디 또는 비밀번호가 다릅니다."));
    }
}
