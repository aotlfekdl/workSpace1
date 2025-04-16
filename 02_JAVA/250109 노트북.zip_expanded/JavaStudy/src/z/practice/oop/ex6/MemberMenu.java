package z.practice.oop.ex6;

import java.util.Scanner;


public class MemberMenu {

	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	public MemberMenu() {
		
	}
	public void mainMenu() {
		System.out.println("최대 등록 가능한 회원수는 10명 입니다.");
		System.out.println("현재 등록된 회원 수는"+"명입니다.");
		System.out.println("1. 새 회원 등록");
		System.out.println("2. 회원 검색");
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 회원 삭제");
		System.out.println("5. 모두 출력");
		System.out.println("9. 끝내기");
		System.out.println("메뉴 번호 :");
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			insertMember();
			break;
			
		case 2:
			searchMember();
			break;
		case 3:
			updateMember();
			break;
		case 4:
			deleteMember();
			break;
		case 5:
			printAll();
			break;
		case 9:
			System.out.println("프로그램을 종료합니다.");
			return;
		default:
			System.out.println("잘못 입력하셨습니다.");
			break;
			
				
		}
		
	
	}
	
	public void insertMember() {
		System.out.print("아이디 입력 :");
		String id = sc.next();
		System.out.println("이름 입력 :");
		String name = sc.next();
		System.out.print("비밀번호 입력 :");
		String password = sc.next();
		System.out.print("이메일 입력 :");
		String email = sc.next();
		System.out.print("성별 입력 : ");
		char gender = sc.next().charAt(0);
		if(gender =='M'||gender =='m'||gender =='f'||gender =='F') {
			System.out.println("성별을 다시 입력하세요");
			char gender1 = sc.next().charAt(0);
			gender = gender1;
		}
		
		
		
		System.out.print("나이 입력 :");
		int age = sc.nextInt();
		
		
		
		
		mc.insertMember(id, name, password, email, gender, age);
		
		System.out.println();
		
		
	//	Member[] mber = mc.insertMember(id, name, password, email, gender, age);
		
		
		/*
		mc.checkId(id);
		if(mc.checkId(id) == true) {
			System.out.println("중복된아이디입니다. 다시 입력해주세요");
			String id1= sc.next();
			id = id1;
			
		}
		*/
//		while(true) {
//			if(mc.checkId(id) == true) {
//				System.out.println("중복된아이디입니다. 다시 입력해주세요");
//				String id1= sc.next();
//				id = id1;
//				
//			}
//		}
		
		
		
		
		
	}
	public void searchMember() {
		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.println("메뉴 번호 :");
		int sechoice = sc.nextInt();
		
		switch(sechoice) {
		case 1:
			searchId();
			break;
			
		case 2:
			searchName();
			break;
			
		case 3:
			searchEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			break;
			
		default :
		}


	}
	public void searchId() {
		System.out.println("검색할 아이디를 입력해주세요");
		String id = sc.next();
		mc.searchId(id);
		
		
		
		
	}
	public void searchName() {
	}
	
	public void searchEmail() {
		
	}
	public void updateMember() {

	}
	public void updatePassword() {
	}
	public void updateName() {
	}
	public void updateEmail() {
	}
	public void deleteMember() {
	}
	public void deletcOne() {
	}
	public void deleteAll() {
	}
	public void printAll() {
		
	}
			
}
