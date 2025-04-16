package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ThumbnailDetailController
 */
@WebServlet("/detail.th")
public class ThumbnailDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//게시글에 대한 정보를 담아와야한다. 
		//BOARD 로 받아오기 가능? type2 로 구별 가능하긴함
		BoardService bservice = new BoardService();
		
		
		int thumbNo = Integer.parseInt(request.getParameter("bno"));
		int result = bservice.increaseCount(thumbNo);
		
		
		Board b1 = new Board();
		b1= new BoardService().selectThumbnail(thumbNo);
		ArrayList<Board> list = new BoardService().selectThumbnail2(thumbNo);
		
		
		if(b1 != null) {
			request.setAttribute("board", b1);
			request.setAttribute("list", list);
			request.setAttribute("result", result);
			request.getRequestDispatcher("views/board/thumbDetailView.jsp").forward(request, response);
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
