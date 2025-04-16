package o.collection.map.ex1;

import java.util.Scanner;
import java.util.TreeMap;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("========== KH 사이트 ==========");
			
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 같은 이름 회원 찾기");
			System.out.println("9. 종료");
			System.out.println("메뉴 번호 선택 :");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			
			case 1:
				joinMembership();
				break;

			case 2:
				this.logIn();
				this.MemberMenu();
				break;
			case 3:
				sameName();
				break;
			case 9:
				return;
			default :
				break;
				
			
			
			}
		}
	}
	
		
	public void MemberMenu() {
		while(true) {
				
			System.out.println("******* 회원 메뉴 *******");
			System.out.println("1. 비밀번호가입");
			System.out.println("2. 이름 바꾸기");
			System.out.println("3. 로그아웃");
			System.out.println("메뉴 번호 선택 :");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				this.changePassword();
				break;
			case 2:
				this.changeName();
				break;
			case 3:
				return;
			default :
				System.out.println("잘못입력함");
				break;
				
			
			
			}
		}
	}
	public void joinMembership() {
		String id, password;
		System.out.println("아이디");
		id = sc.next();
		System.out.println("비밀번호");
		password = sc.next();
		System.out.println("이름 :");
		String name = sc.nextLine();
		System.out.println();
		Member m = new Member();
		
	}
	public void logIn() {
		while(true) {
			String name;
			String id, password;
			System.out.println("아이디");
			id = sc.next();
			System.out.println("비밀번호");
			password = sc.next();
			System.out.println("이름 입력 :");
			name = sc.next();
	
			System.out.println();
			Member m = new Member(id, password);
			mc.login(id, password);
			
			if(name != null) {
				System.out.println(name +"환영합니다.");
			}else{
				System.out.println("틀린아이디 또는 비밀번호 입니다. 다시 입력해주세요.");
			}
		}
	}
	
	
	
	public void changePassword() {
		String id, pwd, newPwd ;
		System.out.println("아이디");
		id = sc.next();
		System.out.println("비밀번호");
		pwd = sc.next();
		System.out.println("새로운 비밀번호");
		newPwd = sc.next();

		
		if(mc.changPassword(id, pwd, newPwd)) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
	public void changeName() {
		while(true) {
			
			
			String id, password;
			System.out.println("아이디");
			id = sc.next();
			System.out.println("비밀번호");
			password = sc.next();
			
			String name  = mc.login(id, password);
			if(name != null) {
				System.out.println("현재설정된 이름 : " + name);
				
				System.out.println("변경할 이름: ");
				
				String newName = sc.nextLine();
				mc.changeName(id, newName);
				
				}else {
					System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요");
				}
					
		}
		
	}
	public void sameName() {
		System.out.println("검색할 아이디");
		String name = sc.nextLine();
		TreeMap result = mc.sameName(name);
		if(result.isEmpty()) {
			System.out.println(name + "이라는 회원을 찾지 못하였습니다.");
		}else {
			for(Object entry : result.entrySet()) {
				Entry<String, String> en = (Entry)entry;
				System.out.println(en.getKey() + "-"+ e);
				
			}
		}
		
		mc.sameName(name);
	}
}




