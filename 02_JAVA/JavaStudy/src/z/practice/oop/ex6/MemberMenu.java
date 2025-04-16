package z.practice.oop.ex6;

import java.util.Scanner;

import z.practice.oop.ex5.Student;


public class MemberMenu {

	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	public MemberMenu() {
		
	}
	public void mainMenu() {
		
		while(true) {
			System.out.println("최대 등록 가능한 회원수는 "+mc.SIZE+"명 입니다.");
			System.out.println("현재 등록된 회원 수는"+mc.existMemberNum()+"명입니다.");
			if(mc.existMemberNum() <= 9) {
				System.out.println("1. 새 회원 등록");
			}else {
				System.out.println("최대 등록 가능 회원수를 초과하였습니다.");
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
			}
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 삭제");
			System.out.println("5. 모두 출력");
			System.out.println("9. 끝내기");
			System.out.println("메뉴 번호 :");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				this.insertMember();
				break;
				

				
			case 2:
				this.searchMember();
				break;
			case 3:
				this.updateMember();
				break;
			case 4:
				this.deleteMember();
				break;
			case 5:
				this.printAll();
				break;
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
				
					
			}
		}
		
	
	}
	
	public void insertMember() {
		// 회원 등록에 필요한 아이디, 이름, 비밀번호, 이메일, 성별, 나이를
		// 사용자에게 직접 입력 받되 아이디의 경우 기존 회원의 아이디와
		// 중복되지 않도록 mc의 checkId()메소드를 통해서 중복 검사를 함
		// 중복 검사를 한 결과 값에 따라 중복 값이 없으면 다음으로 넘어가고
		// 있으면 “중복된 아이디입니다. 다시 입력해주세요.”라는 문구를 출력 후
		// 다시 아이디를 받도록 함
		// 성별의 경우 M이나 m, F나 f가 아니면 “성별을 다시 입력하세요.”를
		// 출력 후 다시 성별을 입력하도록 함
		// 아이디부터 나이까지 모든 데이터를 받았으면
		// mc의 insertMember메소드의 매개변수로 넘김

		String id, name, password, email;
		
		char gender;
		int age;
		
		while(true) {
			System.out.println("아이디입력");
			id = sc.next(); 
				if(mc.checkId(id)) {
					break;
				}
				System.out.println("사용불가능");
			}
		

		System.out.println("이름 입력 :");
		name = sc.next();
		System.out.print("비밀번호 입력 :");
		password = sc.next();
		System.out.print("이메일 입력 :");
		email = sc.next();
		
		while(true) {
			System.out.print("성별 입력 : ");
			gender = sc.next().charAt(0);
			
			if(gender =='M'||gender =='m'||gender =='f'||gender =='F') {
				break;
				
			}else {
				System.out.println("성별을 다시 입력하세요");
				
			}
		}
		
		System.out.println("나이 입력: ");
		age = sc.nextInt();
		sc.nextLine();//개행문자 비움
		
		mc.insertMember(id, name, password, email, gender, age);

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
				return;
				
			default :
				System.out.println("잘못 입력하셨습니다.");
				return;
			}
		}


	
	public void searchId() {
		String id;
		System.out.println("검색할 아이디를 입력해주세요");
		 id = sc.next();
		
		String result = mc.searchId(id);
		if(result == null) {
			System.out.println("검색 결과가 없습니다.");
		}else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			System.out.println(result);
		}
		
		
		
		
		
	}
	public void searchName() {
		String name;
		System.out.println("검색할 이름 : ");
		name = sc.next();
		
		Member[] mArr = mc.searchName(name);
		
		if(mArr[0] == null) {
		}else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for(Member mem : mArr) {
				if(mem == null) {
					break;
				}else {
				System.out.println(mem.inform());
				}
			}
		}
				
			
		
		
		
		
	
		
	}
	
	public void searchEmail() {
		String email;
		System.out.println("검색할 이메일 :");
		email = sc.next();
		
		Member[] result = mc.searchEmail(email);
		if(result[0] == null) {
		}else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for(Member mem : result) {
				if(mem == null) {
					break;
				}else {
					System.out.println(mem.inform());
				}
			}
		}
		
		
		
	}
	public void updateMember() {
		int choice;
		System.out.println("1. 비밀번호 수정하기 :");
		System.out.println("2. 이름 수정하기 :");
		System.out.println("3. 이메일 수정하기 :");
		System.out.println("9. 메인으로 돌아가기 :");
		System.out.println("메뉴 번호 :");
		choice = sc.nextInt();
		


	}
	public void updatePassword() {
		// 수정할 회원 id와 비밀번호를 사용자에게 입력 받고 입력 받은 데이터를
		// mc의 updatePassword() 메소드의 매개변수로 넘김, 반환 값에 따라
		// 검색결과 없으면 “존재하지 않는 아이디입니다.” 출력, mainMenu()로 감
		// 검색 결과가 있으면 “수정이 성공적으로 되었습니다.” 출력 후
		// mainMenu()로 돌아감
		String id, password;
		
		System.out.println("수정할 아이디 :");
		id = sc.next();
		
		
		System.out.println("수정할 비밀번호");
		password = sc.next();
		sc.nextLine();
		
		boolean isUpdate = mc.updatePassword(id, password);
		if(isUpdate) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
		
		
	}
	public void updateName() {
	}
	public void updateEmail() {
	}
	public void deleteMember() {
		int choice;
		System.out.println("1. 특정 회원 삭제하기  :");
		System.out.println("2. 모든 회원 삭제하기 :");
		System.out.println("9. 메인으로 돌아가기 :");
		System.out.println("메뉴 번호 :");
		choice = sc.nextInt();
		
		
		switch(choice) {
		case 1:
			deleteOne();
			break;
			
		case 2:
			deleteAll();
			break;
	
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			return;
			
		default :
			System.out.println("잘못 입력하셨습니다.");
			return;
		}
	}
		
		
	
	public void deleteOne() {
		// 삭제할 회원 id를 사용자에게 입력 받고 정말 삭제할 것인지 사용자에게
		// 물어본 뒤, Y나 y를 사용자가 입력할 경우 입력 받은 id를
		// mc의 delete() 메소드의 매개변수로 넘김, 반환 값에 따라
		// 검색결과 없으면 “존재하지 않는 아이디입니다.” 출력, mainMenu()로 감
		// 검색 결과가 있으면 “성공적으로 삭제하였습니다.” 출력 후
		// mainMenu()로 돌아감
		String id;
		System.out.println("삭제할 ID :");
		id = sc.next();
		System.out.println("정말 삭제하시겠습니까? (y/n) :");
		char result = sc.next().toLowerCase().charAt(0);
		if(result =='y') {
			boolean isDelete =mc.delete(id);
			if(isDelete) {
				
			
				System.out.println("성공적으로 삭제하였습니다.");
			}else {
				System.out.println("존재하지 않는 아이디입니다.");
			}
		}
	}

	
	public void deleteAll() {
		// 정말 삭제할 것인지 사용자에게 물어본 뒤, Y나 y를 사용자가 입력할 경우
		// mc의 delete() 메소드 호출, “성공적으로 삭제하였습니다.” 출력 후
		// mainMenu()로 돌아감
		System.out.println("정말 삭제하시겠습니까? (y/n) :");
		char result = sc.next().toLowerCase().charAt(0);
		if(result =='y') {
			mc.delete();
			System.out.println("성공적으로 삭제하였습니다.");
		}
	}
	public void printAll() {
		Member[] mArr = mc.printAll();
		for(Member mem : mArr) {
			if(mem == null) {
				break;
			}else {
				System.out.println(mem.inform());
			}
		
		}
	}
}
	
		
	
		

