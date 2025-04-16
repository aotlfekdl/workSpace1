package com.kh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestPostServlet
 */
@WebServlet("/RequestPostServlet")
public class RequestPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//POST방식같은 경우에도 동이랗게 데이터를 사용하면 된다.
		// request.setCharacterEncoding("UTF-8"); tomcat 구버전에서는 문자셋 변경이 필요하다. 
		//안그러면 한글이 깨짐
		System.out.println("POST로 전달됨");
		
			String name = request.getParameter("name"); //홍승민 | 안썼으면 ""
			String gender = request.getParameter("gender"); //M | F | NULL 체크안했으면 NULL
			int age = Integer.parseInt(request.getParameter("age"));
			String city = request.getParameter("city"); //"경기" |"서울" 등등)
			double height = Double.parseDouble(request.getParameter("height")); //"170.0" 
			//체크박스와 같이 여러개의 값을 추출하고자 할때
			String[] foods = request.getParameterValues("food"); //["한식"] | ["한식","중식"]|NULL
			System.out.println("name :" + name);
			System.out.println("gender :" + gender);
			System.out.println("age :" + age);
			System.out.println("city :" + city);
			System.out.println("height :" + height);
			System.out.println("food :" + String.join(",",foods));	
			
			//service > dao > db
			
			/*
			 * int result = new MemberService().insertMember(name, gender...);
			 * if(result > 0){
			 *		성공
			 *}else{
			 *		실패
			 *}
			 * */
			
			//변환방식 1. 데이터를 그대로 돌려준다.(REST API 방식에서 사용)
			//변환방식 2. 서버사이드방식으로 html을 java코드로 완성해서 돌려준다.(jsp, thymeleaf)
			
			//jsp(Java Server Page)방식 : html 내에 java코드를 쓸 수 있음
			//응답페이지를 만드는 과정을 jsp에게 위임
			//단, 응답화면에서 필요로 하는 데이터들을 차곡차곡 담아서 전달해줘야 한다.
			//데이터들응ㄹ 담기위한 고안 =: request의 attribute영역
			//request.setAttribute("키", 값);
			
			request.setAttribute("name", name);
			request.setAttribute("gender", gender);
			request.setAttribute("age", age);
			request.setAttribute("city", city);
			request.setAttribute("height", height);
			request.setAttribute("foods", foods);
			
			//현재 요청을 responsePage.jsp로 전달하기 위한 객체
			RequestDispatcher view = request.getRequestDispatcher("/view/responsePage.jsp");
			//위에서 설정한 뷰로 응답을 위임함
			view.forward(request, response);
			
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("POST로 전달됨");
		doGet(request, response);
	}

}
