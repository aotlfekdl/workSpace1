<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="init(${b.boardNo})">

    <jsp:include page="../common/menubar.jsp" />

    <div class="outer" align="center">
        <br>
        <h1 align="center">게시판 상세조회</h1>
        <br>

        <table align="center" border="1">
            <tr>
                <td width="100">글번호</td>
                <td width="500">${b.boardNo}</td>
            </tr>
            <tr>
                <td>제목</td>
                <td>${b.boardTitle}</td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>${b.userId}</td>
            </tr>
            <tr>
                <td>조회수</td>
                <td>${b.count}</td>
            </tr>
            <tr>
                <td>작성일</td>
                <td>${b.createDate}</td>
            </tr>
            <tr>
                <td>내용</td>
                <td height="100">
                    ${b.boardContent}
                </td>
            </tr>
        </table>

        <br>
	<div id="reply-area">
        <table align="center" class="list-area">
                <thead>
                    <tr>
                        <th>댓글작성</th>
                        <c:choose>
                            <c:when test="${loginUser == null}">
                                <td>
                                    <textarea cols="50" rows="3" style="resize: none;" readonly>댓글등록을 하시려면 로그인이 필요합니다.</textarea>
                                </td>
                                <td>
                                    <button disabled>댓글등록</button>
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td>
                                    <textarea id="reply-content" cols="50" rows="3" style="resize: none;"></textarea>
                                </td>
                                <td>
                                    <button onclick="insertReply(${b.boardNo})">댓글등록</button>
                                </td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        
          <script>
                function init(bno){
                    getReplyList(bno, function(data){
                        drawReplyList(data);
                    });
                }

                function insertReply(bno){
                   const contentArea = document.querySelector("#reply-content");

                   $.ajax({
                    url: "rinsert.bo",
                    type: "post",
                    data: {
                        boardNo: bno,
                        content: contentArea.value  
                    },
                    success: function(res){
                        contentArea.value = ""; //댓글 입력창 초기화
                        //댓글목록 다시 불러와서 그려주기
                        getReplyList(bno, function(data){
                            drawReplyList(data);
                        });
                    },
                    error: function(error){
                        console.log("댓글 작성 ajax통신 실패");
                    }
                   })
                }

                function getReplyList(boardNo, callback){
                    $.ajax({
                        url : "rlist.bo",
                        // contextType: "application/json",
                        dataType: "json", //응답 데이터 타입(json, text, html, xml)
                        data : {
                            bno : boardNo
                        },
                        success: function(replyList){
                            callback(replyList);
                        }, 
                        error: function(){
                            console.log("댓글 조회 ajax통신 실패");
                        }
                    })
                }
                function drawReplyList(replyList){
                    let str = "";
                    for(let r of replyList) {
                        str += "<tr>" +
                                "<td>" + r.userId + "</td>" +
                                "<td>" + r.replyContent + "</td>" +
                                "<td>" + r.createDate + "</td>" +
                              "</tr>";
                    }
                    const replyBody = document.querySelector("#reply-area tbody");
                    replyBody.innerHTML = str;
                }
            </script>
        </div>
    </div>
</body>
</html>