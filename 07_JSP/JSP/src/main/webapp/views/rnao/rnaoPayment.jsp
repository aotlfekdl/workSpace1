<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String name = (String)request.getAttribute("name");
String product = (String)request.getAttribute("product");
String number = (String)request.getAttribute("number");
String grade = (String)request.getAttribute("grade");
String order = (String)request.getAttribute("order");
String pizza = (String)request.getAttribute("pizza");
String[] toppingList = (String[])request.getAttribute("toppingList");
String[] sideList = (String[])request.getAttribute("sideList");
String payment = (String)request.getAttribute("payment");
int price = (int)request.getAttribute("price");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결제 페이지</h1>
	<h4>[ 구매자 정보 ]</h4>
	
	<ul>
		<li><%=name %></li>
		<li><%=product %></li>
		<li><%=number %></li>
		<li><%=grade %></li>
		<li><%=order %></li>
	</ul>
	
	<br>
	<h4>[ 주문 정보]</h4>
	
	 <ul>
	 	<li>피자 : <%=pizza %></li>
	 	<% if(toppingList ==null){ %>
	 	<li>토핑 : 선택안함</li>
	 	<%}else{ %>
	 	<li>토핑 : <%=String.join(",", toppingList) %></li>
	 	<%} %>


<% if(sideList ==null){ %>
	 	<li>사이드 : 선택안함</li>
	 	<%}else{ %>
	 	<li>사이드 : <%=String.join(",", sideList)%></li>
	 	<%} %>
	 	        <li>결제방식 : <%=payment%></li>
        <h3>위와같이 주문하셨습니다.</h3>

        <h2>총 가격 : <%=price%>원 입니다.</h2>
	 		 	
	 </ul>
	
</body>
</html>