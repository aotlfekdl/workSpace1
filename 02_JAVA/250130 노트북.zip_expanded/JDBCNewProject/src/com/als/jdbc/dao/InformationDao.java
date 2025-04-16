package com.als.jdbc.dao;

import static com.als.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.als.jdbc.member.Member;
import com.als.jdbc.movie.Movie;
import com.als.jdbc.seat.Seat;

public class InformationDao {
	private Properties prop = new Properties();
	
	
	public InformationDao() {
		super();
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insertMovie(Movie m, Connection conn) {//관리자메뉴 - 영화 추가하기
		int result = 0;
		PreparedStatement pstmt = null;
		
	
		
		String sql = prop.getProperty("insertMovie");
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  m.getTitle());
			pstmt.setInt(2,  m.getAge());
			pstmt.setString(3,  m.getGenre());
			pstmt.setString(4,  m.getDirector());
			pstmt.setString(5,  m.getCompany());
			
			
			result = pstmt.executeUpdate();
			System.out.println(result);

			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Movie> selectMovie(Connection conn){
		ArrayList<Movie> list = new ArrayList();
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("selectMovie");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Movie m = new Movie();
				m.setTitleno(rset.getInt("TITLENO"));
				m.setTitle(rset.getString("TITLE"));
				m.setAge(rset.getInt("AGE"));
				m.setGenre(rset.getString("GENRE"));
				m.setDirector(rset.getString("DIRECTOR"));
				m.setCompany(rset.getString("COMPANY"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
				close(rset);
				close(pstmt);
		}
		return list;
		
		
	}
	
	public int updateMovie(Movie m, Connection conn) {//관리자메뉴 - 영화 목록 출력
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateMovie");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, m.getAge());
			pstmt.setString(2, m.getGenre());
			pstmt.setString(3,  m.getDirector());
			pstmt.setString(4, m.getCompany());
			pstmt.setString(5, m.getTitle());
			
			
			result = pstmt.executeUpdate();
			System.out.println(result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteMovie(String title, Connection conn) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		Movie m = new Movie();
		
		String sql = "DELETE FROM MOVIE WHERE TITLE = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
			
		
		}
		return result;
	}
	
	public ArrayList<Movie> searchMovieTitle(String title, Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Movie> list = new ArrayList();
		Movie m = new Movie();
		
		String sql = "SELECT * FROM MOVIE WHERE TITLE = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			
			rset= pstmt.executeQuery();
			
			while(rset.next()) {
				m.setTitleno(rset.getInt("TITLENO"));
				m.setTitle(rset.getString("TITLE"));
				m.setAge(rset.getInt("AGE"));
				m.setGenre(rset.getString("GENRE"));
				m.setDirector(rset.getString("DIRECTOR"));
				m.setCompany(rset.getString("COMPANY"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public int movieReservationTable(String title, String timeHH, String timeMM, Connection conn) {
		Movie m = new Movie();
		PreparedStatement pstmt = null;
		int result =0;
		
		String sql  = "CREATE TABLE "+title+timeHH+timeMM+"SEAT ("
				+ "SEATNO NUMBER PRIMARY KEY,"
			    + "USERID VARCHAR2(50),"
			    + "SEATROW CHAR(1) NOT NULL,"
			    + "SEATNUMBER NUMBER NOT NULL, "
			    + "RESERVATION CHAR(1),"
			    + "UNIQUE (SEATROW, SEATNUMBER))";
		
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
	        close(pstmt); 
			
			
			String sql2= "INSERT INTO "+title+timeHH+timeMM+"SEAT VALUES(SEQ_SEATNO.NEXTVAL, NULL, ?, ? , 'O')";
			pstmt = conn.prepareStatement(sql2);
			
			String[] seatrow = {"A", "B","C", "D", "E"};
			
			for(String s : seatrow) {
				for(int i = 1; i<= 5; i++) {
					
						pstmt.setString(1, s);
						pstmt.setInt(2, i);
						pstmt.executeUpdate();
					}
				}
			}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
	}

	public ArrayList<Member> selectMemberAll(Connection conn){
		ResultSet rset = null;
		PreparedStatement pstmt = null;
		ArrayList<Member> list = new ArrayList();
		
		String sql = "SELECT * FROM MEMBER";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				list.add(m);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	public int insertMember(Member m, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL,?,?,?,?,?,?,?)";
	
		try {

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			
			result = pstmt.executeUpdate();
			
		
			
			

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Member> selectMember(String userid, Connection conn) {
		ArrayList<Member> list = new ArrayList();
		Member m = new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  userid);
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	public int updateMember(Member m, Connection conn) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBER SET USERPWD =?,"
				 				+ "AGE = ?,"
				 				+ "EMAIL = ?, "
				 				+ "PHONE = ?"
				 				+"WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserPwd());
			pstmt.setInt(2, m.getAge());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getUserId());
			
			result =pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteMember(String userid, Connection conn) {
		int result =0;
		
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	/*
	public ArrayList<Seat> movieSeat(Connection conn){
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<Seat> list = new ArrayList<>();
		String sql = "SELECT * FROM SEAT";
		
		
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Seat seat = new Seat();
				
				seat.setSeatNo(rset.getInt("SEATNO"));
				seat.setSeatRow(rset.getString("SEATROW"));
				seat.setSeatNumber(rset.getInt("SEATNUMBER"));
				seat.setReservation(rset.getString("RESERVATION"));
				list.add(seat);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		

	}
	*/
	
	
public ArrayList<Seat> movieSeat(String tablename, Connection conn){
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Seat> list = new ArrayList<>();
		
		String sql = "SELECT * FROM "+tablename+"SEAT";
		
		
		
		try {
			pstmt= conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Seat seat = new Seat();
				
				seat.setSeatNo(rset.getInt("SEATNO"));
				seat.setSeatRow(rset.getString("SEATROW"));
				seat.setSeatNumber(rset.getInt("SEATNUMBER"));
				seat.setReservation(rset.getString("RESERVATION"));
				list.add(seat);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
		
	}
	
	
	public int movieReservation(String userid,String tablename, String seatrow, int seatnumber, Connection conn) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE "+tablename+"SEAT SET USERID = ? ,"
				+ "RESERVATION = ?"
				+ "WHERE SEATROW = ? AND SEATNUMBER = ? AND RESERVATION = ?"; 
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			pstmt.setString(2, "X");
			pstmt.setString(3, seatrow);
			pstmt.setInt(4, seatnumber);
			pstmt.setString(5, "O");
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
//	
//	public ArrayList<Member> searchuserid(String seuserid, Connection conn) {
//		PreparedStatement pstmt = null;
//		ArrayList<Member> list = new ArrayList();
//		ResultSet rset = null;
//		Member m = new Member();
//		
//		String sql = "SELECT * FROM MEMBER WHERE USERID = ?";
//		
//		try {
//			pstmt = conn.prepareStatement(sql);
//			rset = pstmt.executeQuery();
//			m.setUserId(rset.getString("USERID"));
//			
//			while(rset.next()) {
//				m.setUserNo(rset.getInt("USERNO"));
//				m.setUserId(rset.getString("USERID"));
//				m.setUserPwd(rset.getString("USERPWD"));
//				m.setUserName(rset.getString("USERNAME"));
//				m.setGender(rset.getString("GENDER"));
//				m.setAge(rset.getInt("AGE"));
//				m.setEmail(rset.getString("EMAIL"));
//				m.setPhone(rset.getString("PHONE"));
//				list.add(m);
//			}
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			close(rset);
//			close(pstmt);
//		}
//		
//		return list;
//	}
	
	public ArrayList<Member> searchuserid(String seuserid, Connection conn) {
		ArrayList<Member> list = new ArrayList();
		Member m = new Member();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  seuserid);
			rset = pstmt.executeQuery();
			
			
			while(rset.next()) {
				m.setUserNo(rset.getInt("USERNO"));
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}

}
