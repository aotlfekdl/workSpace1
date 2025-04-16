package com.kh.member.controller;

import java.io.IOException;

import com.kh.member.model.vo.Member;
import com.kh.member.service.MemberService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/delete.me")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int result = 0;
		String userPwd = request.getParameter("userPwd");
		HttpSession session = request.getSession();

		Member loginUser = (Member)session.getAttribute("loginUser");
	
		
		String userId = loginUser.getUserId();
		
		
		
//		result = new MemberService().deleteMember(userId ,userPwd);
		
		if(loginUser == null || !loginUser.getUserPwd().equals(userPwd)) {
			request.setAttribute("errorMsg", "정상적인 접근이 아닙니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
			return;
		}else {
			result = new MemberService().deleteMember(userId);
		}
		
		
		
		if(result > 0) { //성공
//			session.setAttribute("alertMsg", "탈퇴가 정상적으로 처리되었습니다.");
//			session.invalidate();  //세션이 만료되었기 때문에 위의 alert메시지를 사용할 수 없다.  그래서 removeAttribute를 사용한다.
			

			
			session.removeAttribute("loginUser");
			session.setAttribute("alertMsg", "회원탈퇴가 정상적으로 처리되었습니다.");
			
			response.sendRedirect(request.getContextPath());
		}else {
			session.setAttribute("errorMsg", "탈퇴가 되지 않았습니다.");

			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
