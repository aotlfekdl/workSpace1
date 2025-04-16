package com.kh.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RnaoServlet
 */
@WebServlet("/confirmrnao.do")
public class RnaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RnaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청처리
		String name = request.getParameter("userName");
		String product =request.getParameter("product");
		String number =request.getParameter("number");
		String grade =request.getParameter("grade");
		String order =request.getParameter("order");
		
		String pizza = request.getParameter("pizza");
		String[] toppingList = request.getParameterValues("topping");
		String[] sideList = request.getParameterValues("side");
		String payment = (String)request.getAttribute("payment");
		

		int price= 0;
		switch(pizza) {
		case "콤비네이션" : 
			price += 20000;
			break;
		case "포테이토피자" : 
			price += 22000;
			break;
		case "고구마피자" : 
			price += 24000;
			break;
		case "치즈피자" : 
			price += 26000;
			break;
		case "하와이안피자" : 
			price += 28000;
			break;
		}
		
		if(toppingList !=null) {
			for(String topping : toppingList) {
				switch(topping) {
				case "고구마무스" :
					price += 2000;
					break;
				case "치즈크러스트", "치즈바이트" :
					price += 2500;
					break;
				case "치즈추가" :
					price += 3000;
					break;
				case "베이컨/소세지" :
					price += 3500;
					break;
				case "파인애플" :
					price += 4000;
					break;
				}
			}
		}
		
		//Object타입으로 넘어가기떄문에 payment에서 String으로 형변환해야한다.
		//Object타입인 이유는? 스트링과 배열도 같이 있기때문에 모든걸 받아줄 수 있는것은 Object이기 때문이다.
		//그래서 Object로 넘긴다.
		request.setAttribute("name", name);
		request.setAttribute("product", product);
		request.setAttribute("number", number);
		request.setAttribute("grade", grade);
		request.setAttribute("order", order);
		
		request.setAttribute("pizza", pizza);
		request.setAttribute("toppingList",toppingList);
		request.setAttribute("sideList", sideList);
		request.setAttribute("payment", payment);
		request.setAttribute("price", price);
		
		
		RequestDispatcher view = request.getRequestDispatcher("views/rnao/rnaoPayment.jsp");
		view.forward(request, response);
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
