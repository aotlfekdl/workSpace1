package com.als.jdbc.view;

import java.lang.reflect.Member;
import java.util.Scanner;

import com.als.jdbc.controller.InformationController;
import com.als.jdbc.movie.Movie;

public class InformationMenu {
	Scanner sc = new Scanner(System.in);
	InformationController ic = new InformationController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("====처음 시작 화면====");
			System.out.println("1. 관리자메뉴");
			System.out.println("2. 관객전용 메뉴");
			System.out.println("9. 프로그램 종료");
			System.out.print("메뉴 번호 :");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				this.administrator();
				break;
			case 2:
				this.member();
				
				break;
	
			case 9:
				System.out.println("프로그램을 종료합니다.");
				return; 
	
			default :
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
				break;
				
			}
		}
	}
	
	public void administrator() { //관리자메뉴
		while(true) {
			System.out.println("====관리자 메뉴====");
			System.out.println("1. 영화 추가하기");
			System.out.println("2. 영화 목록 출력");
			System.out.println("3. 영화 정보 수정");
			System.out.println("4. 영화 삭제");
			System.out.println("5. 영화 상영 일정 및 좌석테이블 생성");
			System.out.println("6. 회원 목록 출력");
			System.out.println("9. 돌아가기");
			System.out.print("메뉴 번호 :");
			
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				this.insertmovie(); //관리자메뉴 - 영화 추가하기
				
				
				break;
				
			case 2:
				ic.selectMovie();//관리자메뉴 - 영화 목록 출력
				
				
				break;
				
			case 3:
				this.updateMovie();//관리자메뉴 - 영화 정보 수정
				
				break;
				
			case 4:
				this.deleteMovie();//관리자메뉴 - 영화 삭제
				
				
				break;
				
			case 5:
				this.movieReservationTable();
				
				break;
				
			case 6:
				this.selectMemberAll(); //관리자메뉴 - 회원 목록 출력
				break;
				
			case 9:
				System.out.println("메인메뉴로 돌아갑니다.");
				
				return;
			default :
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
				
				break;
			}
		}
	}

	public void insertmovie() {//관리자메뉴 - 영화 추가하기
		Movie m = new Movie();
		
		System.out.print("영화 제목 : ");
		String title = sc.next();
		
		System.out.println("연령 제한 : ");
		String age = sc.next();
		
		System.out.print("장르 : ");
		String genre = sc.next();
		
		System.out.print("감독 : ");
		String director = sc.next();
		
		System.out.print("제작사 : ");
		String company = sc.next();

		
		
		
		
		ic.insertmovie(title, age, genre, director, company);
		
	
	}
	public void updateMovie() {//관리자메뉴 - 영화 목록 출력
		System.out.println("수정할 영화제목을 입력해주세요");
		String title = sc.next();
		
		System.out.print("수정할 연령 제한 : ");
		String age = sc.next();
		System.out.print("수정할 영화 장르");
		String genre = sc.next();
		System.out.print("수정할 영화 감독");
		String director = sc.next();
		System.out.print("수정할 영화 제작삼");
		String company = sc.next();
		
		ic.updateMovie(title, age, genre, director, company);
	}

	public void deleteMovie() {
		System.out.print("삭제할 영화 제목을 입력해주세요");
		String title = sc.next();
		
		ic.deleteMovie(title);
		
	}
	
	public void movieReservationTable(){
		System.out.print("영화 제목을 입력해주세요: ");
		String title = sc.next();
		int result =ic.searchMovieTitle(title);
		if(result == 1) {
			
		}else {
			System.out.println("없는 영화입니다.");
			return;
		}
		
		System.out.println("상영 시간을 입력해주세요");
		System.out.print("시간 :");
		String timeHH = sc.next();
		
		System.out.print("분 :");
		String timeMM = sc.next();
		
		sc.nextLine();
		ic.movieReservationTable(title, timeHH, timeMM);
	}
	public void selectMemberAll() {
		ic.selectMemberAll();
	}
	
//	public void reservationcount() {
//		System.out.println("확인할 영화 :");
//		String title;
//		
//		ic.reservationcount(title)
//	}
//=============================================================================================	
//===============================       회원메뉴         ===================================
	public void member() {
		while(true) {
			System.out.println("=====고객 메뉴=====");
			System.out.println("1. 회원 추가하기");
			System.out.println("2. 회원 정보 출력");
			System.out.println("3. 회원 정보 수정");
			System.out.println("4. 회원 탈퇴");
			System.out.println("5. 영화 종류 출력");
			System.out.println("6. 영화 예매 ");
			System.out.println("7, 좌석 확인");
			System.out.println("9. 돌아가기");
			System.out.print("메뉴 번호 :");
		
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				this.insertMember();
				break;
				
			case 2:
				this.selectMember();
				
				break;

			case 3:
				this.updateMember();
				break;

			case 4:
				this.deleteMember();
				
				break;

			case 5:
				ic.selectMovie();
				break;

			case 6:
				this.movieReservation();
				break;
				
			case 7:
				System.out.println("===== 좌석 현황=====");
				//ic.movieSeat();
				
				break;
				
				
			case 8:
				this.searchuserid();
				
				break;


			case 9:
				
				System.out.println("메인메뉴로 돌아갑니다");
				return;
			default :
				System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
				
				break;
			}
		}
	
	}
	
	public void insertMember() {
		
		System.out.println("====회원 추가====");

		
		System.out.print("아이디 : ");
		String userid = sc.next();
		
		System.out.print("비밀번호 : ");
		String userpwd = sc.next();
		
		System.out.print("이름 : ");
		String username = sc.next();
		
		System.out.print("성별(M/F) : ");
		String gender = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();

		System.out.print("이메일 : ");
		String email = sc.next();
		
		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		sc.nextLine();
		
		
		ic.insertMember(userid, userpwd, username, gender, age, email, phone);
		
	}
	
	public void selectMember() {
		System.out.println("====회원 정보 출력====");
		System.out.print("회원 아이디를 입력해주세요");
		String userid = sc.next();
		
		ic.selectMember(userid);
		
	}
	
	public void updateMember() {
		System.out.println("수정할 회원 아이디를 입력해주세요");
		String userid = sc.next();
		
		String seuserid = userid;
		if(ic.searchuserid(seuserid)== 0) {
			return;
		}
		

		System.out.print("수정할 비밀번호 : ");
		String userpwd = sc.next();
		
		System.out.print("수정할 나이 : ");
		int age = sc.nextInt();

		System.out.print("수정할 이메일 : ");
		String email = sc.next();
		
		System.out.print("수정할 전화번호 : ");
		String phone = sc.next();
		
		sc.nextLine();
		
	
		ic.updateMember(userid, userpwd, age, email, phone);
		
		
	}
	
	public void deleteMember() {
		System.out.println("====회원 탈퇴====");
		System.out.print("삭제할 회원 아이디를 입력해주세요 :");
		String userid = sc.next();
		
		ic.deleteMember(userid);
	}
	
	
	
	public void movieReservation() {
		System.out.println("====영화 예매====");
		ic.selectMovie();
		
		
		System.out.print("영화 제목을 입력해주세요: ");
		String title = sc.next();
		int result =ic.searchMovieTitle(title);
		if(result == 1) {
			
		}else {
			System.out.println("없는 영화입니다.");
			return;
		}
		
		
		System.out.println("아이디를 입력해주세요 :");
		String userid = sc.next();
		
		
		if(ic.searchuserid(userid)== 0) {
			return;
		}
	
		System.out.println("영화 시간을 입력해주세요");
		System.out.println("시간(HH) :");
		String timeHH = sc.next();
		System.out.println("분(MM) :");
		String timeMM = sc.next();
		
		System.out.println("현재 좌석 예매 현황");
		ic.movieSeat(title, timeHH, timeMM);
		
		System.out.println("예매할 좌석열을 입력해주세요 :");
		String seatrow = sc.next();

		System.out.println("예매할 좌석 번호를 입력해주세요 :");
		int seatnumber = sc.nextInt();
		
		sc.nextLine();
		
		String tablename = title+timeHH+timeMM;
		ic.movieReservation(userid, tablename,  seatrow, seatnumber);
		
	}
	
	
	public void searchuserid() {
		System.out.println("검색할 아이디를 입력해주세요");
		String userid = sc.next();
		
		String seuserid = userid;
		ic.searchuserid(seuserid);
		
	}
	
	
	
	
	
}
