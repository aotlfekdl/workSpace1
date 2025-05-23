package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.entity.Member;
import com.kh.reactbackend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final String UPLOAD_PATH = "C:\\workspace\\11_SpringBoot\\reactbackend\\src\\main\\resources\\static\\uploadFile\\";

    //createDto : 사용자가 입력한 회원정보
    public String createMember(MemberDto.Create createDto) throws IOException {
        Member member = createDto.toEntity(); //메모리 올라온 member


        String originName = null;
        String changeName = null;

        if (createDto.getFile() != null && !createDto.getFile().isEmpty()){

            originName = createDto.getFile().getOriginalFilename();
            changeName = UUID.randomUUID().toString()+"_"+originName;

            File uploadFile = new File(UPLOAD_PATH+changeName);
            if (!uploadFile.exists()){
                uploadFile.mkdirs();
            }
            createDto.getFile().transferTo(new File(UPLOAD_PATH+changeName));
            member.changeFile(originName, changeName);
        }
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
    public MemberDto.Response updateMember(String userId, MemberDto.Update updateDto) throws IOException {
        Member member = memberRepository.findOne(userId)
                                        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
        member.updateMemberInfo(
                updateDto.getUser_name(),
                updateDto.getUser_pwd() != null && !updateDto.getUser_pwd().isEmpty()?updateDto.getUser_pwd():member.getUserPwd(),
                updateDto.getEmail(),
                updateDto.getPhone(),
                updateDto.getStatus()

        );

        String originName = null;
        String changeName = null;

        if (updateDto.getFile() != null && !updateDto.getFile().isEmpty()){

            originName = updateDto.getFile().getOriginalFilename();
            changeName = UUID.randomUUID().toString()+"_"+originName;

            File uploadFile = new File(UPLOAD_PATH+changeName);
            if (!uploadFile.exists()){
                uploadFile.mkdirs();
            }
            updateDto.getFile().transferTo(new File(UPLOAD_PATH+changeName));
            member.changeFile(originName, changeName);
        }
        memberRepository.save(member);
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

    @Override
    public MemberDto.MemberLoginResponse MemberLoginResponse(Member member) {
        return memberRepository.MemberLoginResponse(member);
    }
}
