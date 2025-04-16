package com.kh.jdbc.controller;

import java.util.ArrayList;

import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;

/*
 * Controller : view를 통해서 사용자가 요청한 기능에 대해 처리하는 객체
 * 				해당 메서드로 전달된 데이터[가공처리 후] Dao로 전달하여 호출
 * 				Dao로부터 반환받은 결과에 따라서 성공/ 실패 여부를 판단하여 응답화면 결정 -> view메서드 호출
 * 
 * 
 * 
 * */

public class MemberController {
	private MemberDao md = new MemberDao();
	
	public void insertMember(String userId, String userPwd, String userName, String gender,
			String age, String email, String phone, String address, String hobby) {
		
		Member m = new Member(userId, userPwd, userName, gender, Integer.parseInt(age), email, phone, address, hobby);
//view로부터 전달받은 값을 바로 dao쪽으로 전달x
//어딘가에 담아서 전달(Member 객체)
		md.insertMember(m);

		//set 방법을 써도 되고
		
//		
//		m.setUserId(userId);
//		m.setUserPwd(userPwd);
//		m.setUserName(userName);
//		m.setGender(Gender);
//		m.setAge(Integer.parseInt(Age));
//		m.setEmail(Email);
//		m.setPhone(Phone);
//		m.setAddress(Address);
//		m.setHobby(Hobby);
	}
	public void selectMember(){
		ArrayList<Member> list = md.selectMember();
		if(list.isEmpty()) {
			System.out.println("정보가 없습니다.");
		}else {
			System.out.println(list);
		}
		md.selectMember();
	}		
	public int updateMember(String userid, String email, String phone, String address, String hobby) {
		Member m = new Member();
	
		m.setUserId(userid);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		m.setHobby(hobby);
		int result = md.updateMember(m);
		return result;
	}
	
	public void deleteMember(String userid) {
		int result =0;
		result = md.deleteMember(userid);
		if(result == 0) {
			System.out.println("실패");
		}else {
			System.out.println("성공");
		}
		
		
		
		
	}
}