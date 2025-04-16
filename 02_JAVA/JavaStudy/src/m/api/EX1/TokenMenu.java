package m.api.EX1;

import java.lang.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TokenMenu {
	Scanner sc = new Scanner(System.in);
	TokenController tc = new TokenController();
	
	public void mainMenu() {
//		1. 지정 문자열 ➔ tokenMenu()
//		2. 입력 문자열 ➔ inputMenu()
//		3. 프로그램 끝내기 ➔ “프로그램을 종료합니다” 출력 후 종료
//		// 잘못 입력했을 시 “잘못 입력하셨습니다. 다시 입력해주세요.” 출력 후 반복
		
		int choice;
		System.out.println("1. 지정 문자열");
		System.out.println("2. 입력 문자열");
		System.out.println("3. 프로그램 끝내기");
		choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			tokenMenu();
			break;
		case 2:
			inputMenu();
			break;
			
		case 3:
			System.out.println("프로그램을 종료합니다.");
			return;
			
		default :
			System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
			break;
		}
		
	}
	public void tokenMenu() {
		String str = "J a v a P r o g r a m ";
		System.out.println("토큰처리 전 글자 : "+ str);
		System.out.println("토큰처리 후 글자 :" +str.length());
	

		
		tc.afterToken(str);
		
	}
	
	public void inputMenu() {
		// tc에 firstCap()로 입력 받은 문자열을 넘기고 반환 값 출력
	//	찾을 문자를 하나 입력하세요 :
		// tc에 findChar()로 위에 입력 받은 문자열과 방금 받은 문자를 인자로 넘겨
		// 반환 값 출력
		String restr;
		System.out.println("문자열을 입력하세요:");
		restr = sc.nextLine();
		
		tc.firstCap(restr);
		
		char input;
		System.out.println("찾을 문자를 하나 입력하세요");
		input = sc.next().charAt(0);
		tc.findChar(restr, input);
		
		
		
		
			
	}
	

}
