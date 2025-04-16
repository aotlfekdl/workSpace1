package jdbc1.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCRun {
	/*
	 * JCBD를 사용하기 위해서는 자바 프로젝트에 jdbc드라이버를 추가해줘야 한다.
	 * 프로젝트 DNZMFFLR -> Properties -> 라이브러리 -> add external jar -> ojdbc.jar추가
	 * 
	 * *JDBC용 객체
	 * -Connection : DB의 연결정보를 담고있는 객체
	 * -[Prepared]Statement : 연결된 DB에 sql문을 전달해서 실행하고, 결과를 받아내는 객체
	 * - ResultSet : SELECT문 실행 후 조회된 결과문을 담는 객체(처음 DB에 데이터를 넣을 때에는 출력할 필요가 없으니까 실행하지 않아도 된다.)
	 * 
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

	public static void main(String[] args) {
		
		
		//필요한 변수 세팅
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("번호 :");
		int num = sc.nextInt();
		
		System.out.print("이름");
		String name = sc.next();
		
		sc.nextLine();
		
		String sql = "INSERT INTO TEST VALUES(?,?)";
		
		
				
		try {
//* 1) JDBC Driver등록 : JDBC인터페이스가 특정 DBMS가 제공하는 클래스를 사용할 수 있도록 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			System.out.println("등록성공");
			
//* 2) Connection생성 : 연결하고자하는 db정보를 입력해서 해당db와 연결할 수 있는 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","C##JDBC1","JDBC1");
			conn.setAutoCommit(false);
//* 3) Statement생성  : Connection객체를 이용해서 생성(sql문을 실행하고 결과를 받는 객체)
			 
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			
			result = pstmt.executeUpdate(sql); //지금 할려고하는것이 INSERT(DML)이니까 update
			//지금 할려고하는것이 INSERT(DML)이니까 update : int -> 업데이트 
			//실행하려고 하는것이 SELECT 라면 stmt.executeQuery : ResultSet->쿼리
			
			if(result > 0) {
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
		

		
		/*		
		
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<Test> list= new ArrayList<>();
		
		String sql = "SELECT * FROM TEST";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("등록 성공");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC1", "JDBC1");
			conn.setAutoCommit(false);
			
			stmt= conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				int tno = rset.getInt("TNO");
				String tname =rset.getString("TNAME");
				Date tdate = rset.getDate("TDATE");

				list.add(new Test(tno, tname, tdate));
				
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(list.size()>0) {
			System.out.println("\n"+list+"\n");
		}else {
			System.out.println("데이터가없습니다.");
		}
		*/
	}

}
