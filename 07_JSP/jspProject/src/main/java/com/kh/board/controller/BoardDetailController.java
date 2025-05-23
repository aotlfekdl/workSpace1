package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.service.BoardService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardDetailController
 */
@WebServlet("/detail.bo")
public class BoardDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//조회수 1 증가 시키고 
		//Board정보 가지고 
		//그럼 일단 no를 가지고 있어야 겠네?

		
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		
		
		BoardService bService = new BoardService();
		int result = bService.increaseCount(boardNo);
		
		
		//Board b = bService.selectBoard(boardNo);
			
		
		
		Board b = bService.selectBoard(boardNo);
		
		
		
		if(result> 0 && b != null) {
			Attachment at = bService.selectAttachment(boardNo);
			request.setAttribute("board", b);
			request.setAttribute("attachment", at);
			request.setAttribute("alertMst", "성공?");
			request.getRequestDispatcher("views/board/boardDetailView.jsp").forward(request, response);			
		}else {
			request.setAttribute("errorMsg", "정상적인 접근이 아닙니다.");

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
