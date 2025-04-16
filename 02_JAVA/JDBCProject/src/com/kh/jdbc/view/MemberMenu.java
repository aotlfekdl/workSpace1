package com.kh.jdbc.view;

import java.util.ArrayList;
import java.util.Scanner;
import com.kh.jdbc.controller.MemberController;
import com.kh.jdbc.model.vo.Member;
/*
 * 
 * View : 사용자와 상호작용을 하는 객체 -> 입력 및 출력
 * 
 * */
public class MemberMenu {
	Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainManu() {
		
		while(true) {
			System.out.println("==========회원관리 프로그램=========");
			
			
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 정보 변경");
			System.out.println("4. 회원 탈퇴");
			System.out.println("9. 프로그램 종료");
			
			System.out.print("메뉴입력 : ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1: 
				this.insertMember();
				break;
			case 2:
				mc.selectMember();
				break;
			case 3: //수정
				this.updateMember();
				break;
			case 4: 
				
				this.deleteMember();
				
				break;
			case 9:
				System.out.println("프로그램 종료");
				return;
			default :
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
				break;
				
			}
		}
		
		
		
	}
	public void updateMember() {
		System.out.println("아이디를 입력해주세요");
		String userid = sc.nextLine();
		
		System.out.print("변경할 이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("변경할 전화번호(-빼고입력) : ");
		String phone = sc.nextLine();
		
		System.out.print("변경할 주소 : ");
		String address = sc.nextLine();
		
		System.out.print("변경할 취미 : ");
		String hobby = sc.nextLine();
		
		mc.updateMember(userid, email, phone, address, hobby);
	}
	
	public String inputMemberID() {
		return null;
	}
	public void insertMember() {
		System.out.println("====회원 추가====");
		
		System.out.println("아이디 입력 :");
		String userId = sc.nextLine();
		System.out.println("비밀번호 입력 :");
		String userPwd= sc.nextLine();
		System.out.println("이름 입력 :");
		String userName= sc.nextLine();
		System.out.println("성별 입력 (M/F) :");
		String gender= sc.nextLine();
		System.out.println("나이 입력 :");
		String age= sc.nextLine();
		System.out.println("이메일 입력 :");
		String email= sc.nextLine();
		System.out.println("전화번호(-빼고) 입력:");
		String phone= sc.nextLine();
		System.out.println("주소 입력 :");
		String address= sc.nextLine();
		System.out.println("취미 입력 : ");
		String hobby= sc.nextLine();
		mc.insertMember(userId, userPwd, userName, gender, age, email, phone, address, hobby);
	}
	
	public void deleteMember() {
		mc.selectMember();
		
		System.out.println("삭제할 아이디를 입력해주세요");
		String userid = sc.nextLine();
		mc.deleteMember(userid);
		
		
	}

	public void displaySuccess(String message) {
	}
	
	public void displayFail(String message) {
		
		
	}
	public void displayNoData(String message) {
		
	}
	
	public void displayMemberList(ArrayList<Member> list) {

	}
}
