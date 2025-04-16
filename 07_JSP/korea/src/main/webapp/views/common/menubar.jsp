<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>

    <!-- Jquery-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

    <!-- 부트스트랩 5.3.3 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    
    <style>
        a{
            text-decoration: none;
            color: black;
        }
        .login-area >*{
            float: right;
        }
        .login-area input[type="button"],
        .login-area input[type="submit"]{
            width: 50%;
            float: left;
        }

        .nav-area{background: yellow;}
        .menu{
            display: table-cell;
            width: 150px;
            height: 50px;
        }
        
        .menu a{
            color: rgb(0, 0, 0);
            font-size: 20px;
            font-weight: bold;
            text-align: center;
            width: 100%;		
            height: 100%;
            line-height: 50px;
            display: block;
        }
    </style>
</head>
<body>
    <div class="login-area">
        <form action="${pageContext.request.contextPath}/login.me">
            <table>
                <tr>
                    <th>아이디</th>
                    <td><input type="text" name="userId" readonly></td>
                </tr>
                
                <tr>
                    <th>비밀번호</th>
                    <td><input type="password" name="userPwd" readonly></td>
                </tr>
                
                <tr>
                    <th colspan="2"><input type="submit" value="로그인"></th>
                    <td><input type="button" value="회원가입"></td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>