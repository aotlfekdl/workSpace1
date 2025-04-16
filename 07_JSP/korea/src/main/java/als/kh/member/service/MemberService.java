package als.kh.member.service;

import java.sql.Connection;

import als.kh.member.vo.Member;

import static als.kh.commom.JDBCTemplate.close;
import static als.kh.commom.JDBCTemplate.getConnection;

public class MemberService {
	
	public Member loginMember(String userId, String userPwd) {
		Connection conn= getConnection();
		Member m = new MemberDao().login(conn, userId, userPwd);
		close(conn);
		return m;
	}
	

}
