<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<style>
    .outer {
    background: #4b89fc;
    color: white;
    width: 1000PX;
    margin: auto;
    margin-top: 50px;
    padding: 10px 0px 50px;
            }
            
            .list-area{
            border: 1px solid white;
            text-align: center;
        }

        .list-area td, .list-area th{
            border: 1px solid white; 
        }

		.list-area select, .list-area input, .list-area textarea{
			width: 100%;
			box-sizing: border-box;
			background: #ffffff;
    		color: black;
		}
</style>


</head>
<body>

<%@ include file="../common/menubar.jsp" %>
<div class="outer">
    <br>
    <h2 align="center">사진게시글 상세보기</h2>
    <br>
    
    <%--
        파일을 전송하기위해서는 enctype="multipart/form-data"
        기본적인 form 전송시 인코딩 타입 -> application/x-www-form-urlencoded
     --%>

        <table align="center" class="list-area">
        
        
            <tr>
                
                <th width="70">제목</th>
                <td width="350">${board.boardTitle}</td>
            
            
            </tr>

            <tr>
                <th>작성자</th>
                <td>${board.userId}</td>
                <th>작성일</th>
                <td>${board.createDate}</td>
               
            </tr>
            <tr> <th>조회수</th>
                <td>${board.count}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3">
                   <div>
                   ${board.boardContent}
                   </div>
                </td>
            </tr>
            <tr>
                <th>대표이미지</th>
                <td colspan="3"><img width="200px" height="100px" src="${pageContext.request.contextPath}/${board.thumbnailImg}" alt=""></td>
            </tr>

			   <tr>
                <th>상세이미지</th>
                <td colspan="3">
                <c:choose>
                <c:when test="${empty list}">
                	상세이미지가 없습니다.
                </c:when>
                <c:otherwise>
                    <c:forEach var="b" items="${list}">
                            <img width="200px" height="150px" src="${pageContext.request.contextPath}/${b.thumbnailImg}" alt="썸네일이미지">
                        </div>
                    </c:forEach>
                </c:otherwise>
                </c:choose>
                </td>
                
               
            </tr>
  
        </table>

        <br>

        <div align="center">
            <a class="btn btn-sm" href="${pageContext.request.contextPath}/list.th">목록가기</a>
            <c:if test="${loginUser != null && loginUser.userId == board.userId}">
                <a class="btn btn-sm" href="${pageContext.request.contextPath}/updateForm.th?bno=${board.boardNo}">수정하기</a>
                <a class="btn btn-sm">삭제하기</a>
            </c:if>
        </div>
        
</div>


</body>
</html>