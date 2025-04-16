package com.kh.jdbc.service;

//static으로 import시 static메서드를 직접 가져올 수 있음
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;

public class MemberService {
	//1) JDBC driver등록
	//2) Connection객체 생성
	//3) Connection객체 처리
	private MemberDao md = new MemberDao();
	
	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result = md.insertMember(m, conn);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
	
		close(conn);
		return result;
	}
	
	public ArrayList<Member> selectList(){
		ArrayList<Member> list = new ArrayList();
		Connection conn = getConnection();
		list = md.selectList(conn);
		
		close(conn);
		return list;
	}
	
	public void updateMember(Member m) {
		Connection conn = getConnection();
		int result = md.updateMember(m, conn);
		
		close(conn);
		
		if(result >0) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	
	}
	
	public ArrayList<Member> selectByUserName(String keyword){
		ArrayList<Member> list = new ArrayList<Member>();
		Connection conn = getConnection();
		
		
		list = md.selectByUserName(keyword, conn);

		close(conn);
		System.out.println(list);
		return list;
	}
	
	public void deleteMember(String userid) {
		Connection conn = getConnection();
		
		int result = md.deleteMember(userid, conn);
		
		close(conn);
		
		if(result > 0) {
			System.out.println("성공");
			
		}else {
			System.out.println("실패");
		}
		
	}
	
	//public int deleteMember(String userId) {
		
	//}
}
