package com.kh.jdbc.view;

import java.util.Scanner;

import com.kh.jdbc.controller.MemberController;

//View : 사용자와 상호작용을 하는 객체 -> 입력및 출력
public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	/*
	 * 사용자가 보게될 첫 화면(메인화면)
	 */
	public void mainMenu() {
		while(true) {
			System.out.println("==========회원관리 프로그램=========");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 정보 변경");
			System.out.println("4. 회원 탈퇴");
			System.out.println("9. 프로그램 종료");
			
			System.out.print("메뉴입력 : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1:
				this.insertMember();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 9:
				System.out.println("이용해주셔서 감사합니다. 종료합니다.");
				return;
			default:
				System.out.println("메뉴를 잘못입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}
	
	public void insertMember() {
		System.out.println("=========== 회원 추가 =============");
		//id~취미
		
		System.out.print("아이디 : ");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호 : ");
		String userPwd = sc.nextLine();
		
		System.out.print("이름 : ");
		String userName = sc.nextLine();
		
		System.out.print("성별(M, F) : ");
		String gender = sc.nextLine();
		
		System.out.print("나이 : ");
		String age = sc.nextLine();
		
		System.out.print("이메일 : ");
		String email = sc.nextLine();
		
		System.out.print("전화번호(-빼고입력) : ");
		String phone = sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		System.out.print("취미 : ");
		String hobby = sc.nextLine();
		
		mc.insertMember(userId, userPwd, userName, gender, age, email, phone, address, hobby);
	}

	//----------------------------응답화면-------------------------
	/**
	 * 서비스요청 처리 후 성공했을 경우 사용자가 보게될 화면
	 * message : 객체별 성공메세지
	 */
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}
	
	/**
	 * 서비스요청 처리 후 실패했을 경우 사용자가 보게될 화면
	 * message : 객체별 실패메세지
	 */
	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}
	
	/**
	 * 조회서비스 요청시 조회결과가 없을 때 사용자가 보게될 응답화면
	 * message : 조회결과에대한 응답메세지
	 */
	public void displayNoData(String message) {
		System.out.println("\n" + message);
	}
}
