<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/JSP/confirmrnao.do" method="POST">
        <fieldset>
            <legend>구매 정보</legend>
                <table>
                구매자 : <input type="text" id="rnao" name="userName"  placeholder="구매자의 이름을 입력하세요" ><br>
                상품명 : <input type="text" id="tkdvna" name="product"  placeholder="구매 상품 명을 입력하세요." ><br>
                
                구매 수량 : <input type="number" name="number" onclick="tnfid(this)" id="tnfid" min="10" max="100" step="10" placeholder="최소 10"> <br>
                납품 등급 : <input type="range" name="grade" min="2" max="9" step="2"><br>
                기타사항 : <textarea name="order"></textarea>
                </table>
        </fieldset>

        <fieldset>
            <legend>주문정보</legend>
            <table>
                <tr>
                    <th>피자</th>
                    <td>
                        <select name="pizza">
                            <option>콤비네이션</option>
                            <option>포테이토피자</option>
                            <option>고구마피자</option>
                            <option>치즈피자</option>
                            <option>하와이안피자</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>토핑</th>
                    <td>
                        <label>
                            <input type="checkbox" name="topping" value="고구마무스"> 고구마무스 
                        </label>
                        <label>
                            <input type="checkbox" name="topping" value="치즈크러스트"> 치즈크러스트 
                        </label>
                        <label>
                            <input type="checkbox" name="topping" value="치즈바이트"> 치즈바이트 
                        </label>
                        <br>
                        <label>
                            <input type="checkbox" name="topping" value="치즈추가"> 치즈추가 
                        </label>
                        <label>
                            <input type="checkbox" name="topping" value="베이컨/소세지"> 베이컨/소세지 
                        </label>
                        <label>
                            <input type="checkbox" name="topping" value="파인애플"> 파인애플 
                        </label>
                    </td>
                </tr>
                <tr>
                    <th>사이드</th>
                    <td>
                        <label>
                            <input type="checkbox" name="side" value="콜라"> 콜라 
                        </label>
                        <label>
                            <input type="checkbox" name="side" value="사이다"> 사이다 
                        </label>
                        <label>
                            <input type="checkbox" name="side" value="환타"> 환타 
                        </label>
                        <br>
                        <label>
                            <input type="checkbox" name="side" value="핫소스"> 핫소스 
                        </label>
                        <label>
                            <input type="checkbox" name="side" value="파마산"> 파마산 
                        </label>
                        <label>
                            <input type="checkbox" name="side" value="피클"> 피클 
                        </label>
                    </td>
                </tr>
                <tr>
                    <th>결제방식</th>
                    <td>
                        <input type="radio" name="payment" value="card" checked> 카드결제
                        <input type="radio" name="payment" value="cash"> 현금결제
                    </td>
                </tr>
            </table>
        </fieldset>

        <br>

        <input type="submit" value="주문">
        <input type="reset">

        
    </form>
    <button onclick="submit(this)">입력 값 클릭하기</button>
    <div id="area1" class="area">

    </div>

</body>
</html>