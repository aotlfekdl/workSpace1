package i.polymotphism.ex1;

import java.util.Scanner;

public class LibraryMenu {

	Scanner sc = new Scanner(System.in);
	LibraryController lc = new LibraryController();
	
	public void mainMenu() {
		String name;
		int age;
		char gender;
		
		System.out.println("이름 :");
		name = sc.next();
		System.out.println("나이 :");
		age = sc.nextInt();
		System.out.println("성별 :");
		gender = sc.next().charAt(0);
		
		Member m = new Member(name, age, gender);
		lc.insertMember(m);
		
//		pc.insertStudent(name, age, height, weight, grade, major);
		
		while(true) {
			
		
			int choice;
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 전체 조회");
			System.out.println("3. 도서 검색");
			System.out.println("4. 도서 대여하기");
			System.out.println("5. 도서 추가하기");//추가 가능한지? 맨 뒤에 추가
			System.out.println("6. 도서 삭제하기");//어떤 도서를 삭제할지?
			System.out.println("9. 프로그램 종료하기");
			System.out.println("메뉴 번호 : ");
			choice = sc.nextInt();
			
			
			switch(choice) {
			case 1:
				lc.myInfo();
				break;
				
			case 2:
				selectAll();
				break;
				
			case 3:
				searchBook();
				break;
				
			case 4:
				rentBook();
				break;
			case 5:
				if(lc.isInsertBook()) {
					insertBook();
				}
				insertBook();
				break;
			case 6:
				deleteBook();
				break;
				
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return;
				
			default:
				System.out.println("잘못입력하였습니다.");
				break;
			}
		}
	
	}
	public void selectAll() {
		Book[] bList =lc.selectAll();
		for(int i= 0; i<bList.length && bList[i] != null; i++) {
			System.out.println(i + "번 도서: " +bList[i]);
		}
		
	}
	public void searchBook() {
		String keyword;
		System.out.println("검색할 제목 키워드 : ");
		keyword = sc.next();
		lc.searchBook(keyword);
		
//		Book [] searchList = lc.searchBook(keyword);
//		for(int i = 0; i< searchList.length && searchList[i] != null; i++){
//			System.out.println(searchList);
//		}
//		
		
	}
	public void rentBook() {
		selectAll();
		
		int index;
		System.out.println("대여할 도서 번호 선택");
		index = sc.nextInt();
		
		
		int result = lc.rentBook(index);
		
		switch (result){
		case 0:
			System.out.println("성공적으로 대여되었습니다.");
			break;
		case 1:
			System.out.println("나이 제한으로 대여 불가능입니다.");
			break;
		case 2:
			System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니, 마이페이지에서 확인하세요");
			break;
		}	
	}
	
	public void insertBook() {
		String title, author, publisher;
		char ac, yn;
		int accessAge;
		System.out.println("책을 추가하겠습니다.");
		
		System.out.println("title : ");
		title = sc.next();
		System.out.println("author : ");
		author = sc.next();
		System.out.println("publisher :");
		publisher = sc.next();
		System.out.println("요리책인지 만화책인지 선택해주세요(c/a) :");
		ac = sc.next().charAt(0);
		if(ac == 'c') {
			System.out.println("요리책의 쿠폰 유무를 선택해주세요(y/n) :");
			yn = sc.next().charAt(0);
			if(yn == 'y') {
			CookBook b = new CookBook(title, author,publisher,true);
			lc.insertBook(new CookBook(title, author,publisher,true));
			}else if(yn =='n') {
				CookBook b = new CookBook(title, author,publisher,false);
				lc.insertBook(new CookBook(title, author,publisher,false));
			}
		}else if(ac == 'a') {
			System.out.println("만화책의 연령제한을 입력해주세요 :");
			accessAge = sc.nextInt();
			
			AniBook b = new AniBook(title, author, publisher, accessAge);
			lc.insertBook(new AniBook(title, author, publisher, accessAge));
		}
		
		
		
		
	}
	public void deleteBook() {
		selectAll();
		int dechoice;
		System.out.println("삭제할 책 번호를 입력해주세요 :");
		dechoice = sc.nextInt();
		lc.deleteBook(dechoice);
		
		
	}
}
