package com.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.jdbc.model.vo.Member;

/*
 * DAO(Data Access Object) : db에 직접적으로 접근해서 사용자의 요청에 맞는 sql문 실행 후 결과 반환(JDBC)
 *  
 * */
public class MemberDao {
	
	/*
	 * 사용자가 입력한 정보들을 db에 추가시켜주는 메서드
	 * Member m : 사용자가 입력한 값들이 담겨있는 Member객체
	 * insert실행 후 처리된 행 수 리턴 
	 * */
	public int insertMember(Member m) {	/*
		 * JCBD를 사용하기 위해서는 자바 프로젝트에 jdbc드라이버를 추가해줘야 한다.
		 * 프로젝트 DNZMFFLR -> Properties -> 라이브러리 -> add external jar -> ojdbc.jar추가
		 * 
		 * 필요한 변수 설정
		 * *JDBC용 객체
		 * -Connection : DB의 연결정보를 담고있는 객체
		 * -[Prepared]Statement : 연결된 DB에 sql문을 전달해서 실행하고, 결과를 받아내는 객체
		 * - ResultSet : SELECT문 실행 후 조회된 결과문을 담는 객체
		 * 
		 * JDBC 사용 순서
		 * 1) JDBC Driver등록 : JDBC인터페이스가 특정 DBMS가 제공하는 클래스를 사용할 수 있도록 등록
		 * 2) Connection생성 : 연결하고자하는 db정보를 입력해서 해당db와 연결할 수 있는 객체 생성
		 * 3) Statement생성  : Connection객체를 이용해서 생성(sql문을 실행하고 결과를 받는 객체)
		 * 4) sql문 전달해서 실행 : Statement객체를 이용해서 sql문 실행
		 * 5) 결과 받기 > SELECT문 실행(6-1) => ResultSet객체(조회된 결과를 담아준다.), DML(INSERT, UPDATE, DELETE)문 실행(6-2) => int
		 * 
		 * 6-1) ResultSet객체에 담겨있는 데이터들을 하나씩 추출해서 차근차근 옮겨담기
		 * 6-2) 트랜잭션 처리(성공했으면 commit, 실패했다면 rollback 실행)
		 * 
		 * 7) 다 사용한 JDBC객체를 반드시 자원 반납(close) => 생성된 역순으로
		 * */
		//필요한 변수 추가
		//1) JDBC Driver등록
		//2) Connection 생성(url, 계정명, 비밀번호)
		//3) Statement생성
		//4, 5) sql문 전달하면서 결과 받기(처리된 행의 수)
		//6) 트랜잭션 처리
		//7)  다 사용한 JDBC객체를 반드시 자원 반납(close) => 생성된 역순으로
		//필요한 변수 추가
		int result= 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL,?,?,?,?,?,?,?,?,?,SYSDATE)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5,  m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			result  = pstmt.executeUpdate();
			if(result> 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(result > 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		return result;
	
	}
	
	public ArrayList<Member> selectMember(){
		ArrayList<Member> list = new ArrayList();
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			
			conn.setAutoCommit(false);
			
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
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
				list.add(m);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
		
		
	}
	
	public int updateMember(Member m) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBER "
					+ "SET EMAIL =?,"
					+ "PHONE =?,"
					+ "ADDRESS = ?,"
					+ "HOBBY = ?"
					+ "WHERE USERID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getHobby());
			pstmt.setString(5, m.getUserId());
			result = pstmt.executeUpdate();
			
			
			
			if(result >0) {//트랜잭션 처리
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(result> 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
					
		return result;
		
	}
	
	public int deleteMember(String userid) {
		
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USERID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userid);
			
			result = pstmt.executeUpdate();
			
			if(result >0 ) {
				conn.commit();
			}else {
				conn.rollback();
			}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(result);
		if(result> 0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		return result;
		
		
	}
}
	