package com.kh.jdbc.service;

//static으로 import시 static메서드를 직접 가져올 수 있음
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;

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
}
