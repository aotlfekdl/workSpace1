package com.kh.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.kh.common.vo.PageInfo;
import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NoticeListController
 */
@WebServlet("/list.no")
public class NoticeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int listCount;
		int currentPage;
		int PageLimit = 10;
		int noticeLimit = 10;
	
		
		listCount = new NoticeService().selectListCount(); //현재 총 게시글 수 
		
		currentPage = Integer.parseInt(request.getParameter("cpage"));//현재 페이지(사용자가 요청한 페이지)
		
		PageInfo pi = new PageInfo(listCount, currentPage, PageLimit, noticeLimit);  //하단에 보여지는 페이지 수
		
		ArrayList<Notice> list = new NoticeService().selectList(pi);//하단에 보여지는 페이지의 배열 ex 1, 2, 3, 4, 5, 6, ...10
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
