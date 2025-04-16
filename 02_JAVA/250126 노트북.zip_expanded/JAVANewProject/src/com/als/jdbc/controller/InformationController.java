package com.als.jdbc.controller;

import java.util.ArrayList;

import com.als.jdbc.dao.InformationDao;
import com.als.jdbc.member.Member;
import com.als.jdbc.movie.Movie;
import com.als.jdbc.movietitle.Movietitle;
import com.als.jdbc.seat.Seat;
import com.als.jdbc.service.InformationService;

public class InformationController {
	InformationService is = new InformationService();
	InformationDao idao = new InformationDao();
	
	
	
	public void insertmovie(String title, String age, String genre, String director, String company) { //관리자메뉴 - 영화 추가하기
		
		Movie m = new Movie(title, Integer.parseInt(age), genre, director, company);
		
		
		int result = is.insertMovie(m);
		
		
		if(result > 0) {
			System.out.println("성공");
		}else {
			
		}
	}
	
	public void selectMovie(){
		ArrayList<Movie> list= new ArrayList<>();
		
		list = is.selectMovie();
		
		System.out.println(list);
		
	}
	
	public void updateMovie(String title, String age, String genre, String director, String company) {//관리자메뉴 - 영화 목록 출력
		
		int result = 0;
		Movie m = new Movie(title, Integer.parseInt(age), genre, director, company);
		
		result =is.updateMovie(m);
		
		if(result >0) {
			System.out.println("성공");
		}else {
			System.out.println("없는 영화입니다.");
		}
		
	}
	public void deleteMovie(String title) {
		
		int result =0;
		result = is.deleteMovie(title);
		
		if(result > 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
	
	public int searchMovieTitle(String title) {
		ArrayList<Movie> list = new ArrayList<>();
		list = is.searchMovieTitle(title);
		int result= 0;
		
		
		
		if(list.isEmpty()) {
			return result;
		}else {
			System.out.println(list);
			System.out.println("조회 성공");
			result = 1;
			return result;
		}
	}
	
	
	public void movieReservationTable(String title, String timeHH, String timeMM) {
		int result = 0;
		
		result = is.movieReservationTable(title, timeHH, timeMM);
		
	
		
		
	}
	
	
	public void deleteMovietable(String title, String timeHH, String timeMM) {

		String tablename = title + timeHH + timeMM;
		
		int result = is.deleteMovietable(tablename);
		
	}
	
	public void selectMemberAll() {
		ArrayList<Member> list = new ArrayList();
		
		list = is.selectMemberAll();
		
		System.out.println(list);
	}
	
	public void insertMember(String userid, String userpwd, String username, String gender, int age, String email, String phone) {
//		Member m = new Member(userid, userpwd, username, gender, Integer.parseInt(age), email, phone);

		Member m = new Member(userid, userpwd, username, gender, age, email, phone);
		int result = is.insertMember(m);
		
		
		System.out.println(result);
		
		if(result > 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}	
	
	public void selectMember(String userid) {
		ArrayList<Member> list = new ArrayList();
		list = is.selectMember(userid);
		
		
		if(!list.isEmpty()) {
			System.out.println(list);
		}else {
			System.out.println("없는 아이디입니다.");
		}
	}
	
	public void updateMember(String userid, String userpwd, int age, String email, String phone) {
		ArrayList<Member> list = new ArrayList();
		Member m = new Member();
		
		m.setUserId(userid);
		m.setUserPwd(userpwd);
		m.setAge(age);
		m.setEmail(email);
		m.setPhone(phone);
		int result = is.updateMember(m);
		
		
		if(result >0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
	}
	
	public void deleteMember(String userid) {
		
		int result;
		
		result = is.deleteMember(userid);
		

		if(result >0) {
			System.out.println("성공");
		}else {
			System.out.println("없는 아이디입니다.");
		}
		
	}
	
	public ArrayList<Seat> movieSeat(String title, String timeHH, String timeMM) {
		ArrayList<Seat> list= new ArrayList();
		
	
		String tablename = title+ timeHH+timeMM;
	
		String tableNameSeat = title+ timeHH+timeMM+"SEAT";
		
		list = is.movieSeat(tablename, tableNameSeat);
	
		
		for(int i = 0; i<list.size(); i++) {
			if(i % 5 == 0) {
				System.out.println();
				
			}
			System.out.print(list.get(i));
		}
		System.out.println();
		return list;
		
		
			
		
	}
	
	public void movieReservation(String userid,String title,String tablename,  String seatrow, int seatnumber) {// 회원 아이디, 티켓 수량, 좌석번호 일단은 티켓 수량은 빼고
		Member m = new Member();
		Seat seat = new Seat();
		
		String tableNameSeat = title+ tablename;
		
		int result = is.movieReservation(userid,title,tableNameSeat,  tablename, seatrow, seatnumber);
		
		if(result > 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}
	
	public void tablesearch(String title){
		ArrayList<Movietitle> list = new ArrayList();

		list = is.tablesearch(title);
		
		System.out.println(list);
	}
	
	public int  searchuserid(String seuserid) {
		ArrayList<Member> list = new ArrayList<>();
		int result = 0;
		
		list = is.searchuserid(seuserid);
		
		if(list.isEmpty()) {
			System.out.println("없는 아이디입니다.");
			return 0;
		}else {
			System.out.println("조회성공"+list);
			return 1;
		}
	}
}
	
