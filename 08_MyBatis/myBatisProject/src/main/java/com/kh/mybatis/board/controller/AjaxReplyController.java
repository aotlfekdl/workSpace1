package com.kh.mybatis.board.controller;

import java.io.IOException;

import com.kh.mybatis.board.model.vo.Reply;
import com.kh.mybatis.board.service.BoardServiceImpl;
import com.kh.mybatis.member.model.vo.Member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AjaxReplyController
 */
@WebServlet("/rinsert.bo")
public class AjaxReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("rinsert경론");
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		System.out.println(boardNo);
		
		HttpSession sqlSession = request.getSession();
		BoardServiceImpl bService = new BoardServiceImpl();
		String replyContent = request.getParameter("content");
		int userNo = ((Member)request.getSession().getAttribute("loginUser")).getUserNo();
		
		System.out.println(boardNo);
		System.out.println(replyContent);
		System.out.println(userNo);
		
		Reply r = new Reply();
		r.setReplyContent(replyContent);
		r.setRefBno(boardNo);
		r.setReplyWriter(userNo);
		
		System.out.println(r);
		
//		r.setRefBno(boardNo);
//		r.setReplyContent(replyContent);
//		r.setReplyWriter(userNo);
		
		int result = bService.insertReply(r);
		response.getWriter().print(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}