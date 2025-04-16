package com.kh.jdbc.controller;

import com.kh.jdbc.model.vo.Member;
import com.kh.jdbc.service.MemberService;
import com.kh.jdbc.view.MemberMenu;

/*
 * Controller : View를 통해서 사용자가 요청한 기능에 대해 처리하는 객체
 * 				해당 메서드로 전달된 데이터[가공처리후] Dao로 전달하여 호출
 * 				Dao로부터 반환받은 결과에 따라서 성공/실패 여부를 판단하여 응답화면 결정-> view메서드 호출
 */
public class MemberController {
	private MemberService ms = new MemberService();
	
	/**
	 * 사용자의 추가요처을 처리하는 메서드
	 * userId~hobby : 사용자가 입력한 정보들을 매게변수로 받음
	 */
	public void insertMember(String userId, String userPwd, String userName, String gender,
								String age, String email, String phone, String address, String hobby) {
		//view로부터 전달받은 값을 바로 dao쪽으로 전달x
		//vo객체에 담아서 service로 전달
		
		Member m = new Member(userId, userPwd, userName, gender, 
				Integer.parseInt(age), email, phone, address, hobby);
		
		int result = ms.insertMember(m);
		if(result > 0) {
			new MemberMenu().displaySuccess("회원 추가 성공");
		} else {
			new MemberMenu().displayFail("회원 추가 실패");	
		}
	}
	
	/**
	 * 회원을 모두 조회하는 메서드
	 */
	public void selectList() {
		
	}
	
	/**
	 * id를 통해서 회원을 삭제하는 메서드
	 */
	public void deleteMember(String userId) {
		
	}
	
	/**
	 * userId, email, phone, address, hobby를 전달받아
	 * Member를 수정하는 메서드
	 */
	public void updateMember(String userId,String email,String phone,String address,String hobby) {
		
	}
}
