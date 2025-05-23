package com.kh.reactbackend.controller;

import com.kh.reactbackend.dto.MemberDto;
import com.kh.reactbackend.entity.Member;
import com.kh.reactbackend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원등록API
    @PostMapping
    public ResponseEntity<String> addMember(@ModelAttribute MemberDto.Create createDto) throws IOException {
        System.out.println("Create Member: " + createDto.getUser_id());
        String userId = memberService.createMember(createDto);
        System.out.println("아이디"+createDto.getUser_id());
        System.out.println(userId);
        return ResponseEntity.ok(userId);
    }

    //회원조회
    @GetMapping("/{id}")
    public ResponseEntity<MemberDto.Response> getMember(@PathVariable("id") String userId) {
        System.out.println("Get Member: ");
        return ResponseEntity.ok(memberService.findMember(userId));
    }

    //전체 회원 조회
    @GetMapping
    public ResponseEntity<List<MemberDto.Response>> getAllMembers() {return ResponseEntity.ok(memberService.findAllMember());}

    //회원수정
    @PutMapping("/{userId}")
    public ResponseEntity<MemberDto.Response> updateMember(@PathVariable("userId") String userId, @ModelAttribute MemberDto.Update updateDto) throws IOException {
        System.out.println("String : userId = ::" + userId);


        return ResponseEntity.ok(memberService.updateMember(userId, updateDto));
    }

    //회원삭제
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteMember(@PathVariable String userId) {
        memberService.deleteMember(userId);
        return ResponseEntity.ok().build();
    }

    //회원삭제(isdeleted 변경 버전)
    @PatchMapping("/{userId}")
    public ResponseEntity<Void> isDeletedMember(@PathVariable String userId) {
        memberService.isDeletedMember(userId);
        return ResponseEntity.ok().build();
    }

    //이름으로 회원 검색
    @GetMapping("/search/name")
    public ResponseEntity<List<MemberDto.Response>> searchMemberByName(@RequestParam String name) {
        return ResponseEntity.ok(memberService.findByName(name));
    }

    //로그인 기능
    @PostMapping("/login")
    public ResponseEntity<MemberDto.MemberLoginResponse> login(@RequestBody MemberDto.login loginDto) {
        Member member = memberService.loginMember(loginDto);


        if (member == null) {

            return ResponseEntity.ok().build();

        }




        return ResponseEntity.ok(memberService.MemberLoginResponse(member));
    }

}