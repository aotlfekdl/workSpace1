package com.als.jdbc.view;

import java.util.Scanner;

import com.als.jdbc.controller.InformationController;
import com.als.jdbc.movie.Movie;

public class InformationMenu {
	Scanner sc = new Scanner(System.in);
	InformationController ic = new InformationController();
	
	public void mainMenu() {
	
		System.out.println("====처음 시작 화면====");
		System.out.println("1. 관리자메뉴");
		System.out.println("2. 관객전용 메뉴");
		System.out.println("9. 프로그램 종료");
		
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			this.administrator();
			
			
			break;
			
		case 2:
			this.reservation();
			
			break;

		case 3:
			System.out.println("프로그램을 종료합니다.");
			return; 

		default :
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			break;
			
		}
	}
	
	public void administrator() {
		System.out.println("====관리자 메뉴====");
		System.out.println("1. 영화 추가하기");
		System.out.println("2. 영화 목록 출력");
		System.out.println("3. 영화 정보 수정");
		System.out.println("4. 영화 삭제");
		System.out.println("5. 영화 예매 수");
		System.out.println("9. 돌아가기");
		System.out.print("메뉴 번호 :");
		
		int choice = sc.nextInt();
		
		switch(choice) {
		case 1:
			this.insertmovie();
			
			
			break;
			
		case 2:
			
			
			break;
			
		case 3:
			
			break;
			
		case 4:
			
			break;
			
		case 5:
			
			break;
			
		case 9:
			
			return;
		default :
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
			
			break;
		}
	}

	public void insertmovie() {
		Movie m = new Movie();
		System.out.println("====영화 추가====");
		System.out.println("영화 제목 : ");
		String title = sc.nextLine();
		
		System.out.println("영화 연령제한 : ");
		String age = sc.nextLine();
		
		System.out.println("영화 장르 : ");
		String genre = sc.nextLine();
		
		System.out.println("영화 감독 : ");
		String director = sc.nextLine();
		
		System.out.println("영화 제작사 : ");
		String company = sc.nextLine();
		
		
		ic.insertmovie(title, age, genre, director, company);
		
		
	
	
	
	}

	}
	
	
}
