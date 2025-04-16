<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<style>
		.outer{
			background: #4b89fc;
			color: white;
			width: 1000PX;
			margin: auto;
			margin-top: 50px;
			padding: 10px 0px 50px;
		}

		.outer table{
			margin: auto;
		}

		#update-pwd-modal .modal-body form{
			display: flex;
			

		}
	</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	
	<div class="outer">
		<br>
		<h2 align="center">내 정보</h2>
		<form action="${pageContext.request.contextPath}/update.me" method="post" id="update-form">
			<table>
				<tr>
					<td>* 아이디</td>
					<td><input type="text" name="userId" maxlength="15" readonly value="${loginUser.userId}"></td>
					<td></td>
				</tr>
				<tr>
					<td>* 이름</td>
					<td><input type="text" name="userName" maxlength="8" readonly value="${loginUser.userName}"></td>
					<td></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" name="phone" placeholder="- 포함해서 입력" value="${loginUser.phone}"></td>
					<td></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" name="email" value="${loginUser.email}"></td>
					<td></td>
				</tr>
				<tr>
					<td>주소</td>
					<td><input type="text" name="address" value="${loginUser.address}"></td>
					<td></td>
				</tr>
				
			</table>
			

			<br><br>

			<div align="center">
				<button type="submit" class="btn btn-sm btn-success">정보수정</button>
				<button type="button" class="btn btn-sm btn-warning" data-bs-toggle="modal" data-bs-target="#update-pwd-modal">비밀번호 변경</button>
				<button type="button" class="btn btn-sm btn-danger"  data-bs-toggle="modal" data-bs-target="#delete-modal">회원탈퇴</button>
			</div>
		</form>
	</div>
	<!-- 
		탈퇴하기 버튼 클릭 시 
		탈퇴 후 복구가 불가능합니다.
		정말 탈퇴하시겠습니까?
		비밀번호 : 
		탈퇴하기 버튼 -> /delete.me
		=> /delete.me받은 서버는 비밀번호가 맞는지 확인 후 status -> N으로 변경하고 로그아웃
	 -->

	
	
</body>
</html> 