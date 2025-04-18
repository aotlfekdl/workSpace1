import React from 'react'




const imgUrl = "https://item.kakaocdn.net/do/30d9c30e9b589e510bbfbed40276c49ef604e7b0e6900f9ac53a43965300eb9a"
const text = "Hello, JSX";
const num = 10;

const loginUser = {
    name : "최지원",
    id : "user01",
    age : 50,
}

const userList = [{
    name : "최지원",
    id : "user01",
    age : 50,
},{ name : "최지투",
    id : "user02",
    age : 40,},{
        name : "최지삼",
        id : "user03",
        age : 30,
    }
]

function getImg(){
    return  <img src="imgUrl" alt="빵빵이" width={100}></img>
}


const numbers = [1,2,3];
const JavaScript = () => {
  return (
    <div>
        <h2>변수 넣는 방법 </h2>
        <ul>
            <li>{text}</li>
            <li>{text + " Text"} </li>
        </ul>
        <h2>숫자 및 계산식 사용</h2>
        <ul>
            <li>{num}</li>
            <li>{num + 20}</li>
        </ul>

        <h2>Boolean 값</h2>

        <ul>
            <li>{true ? <span>안녕</span> : <span>바이</span>}</li>
            <li>{false}</li>
            <li>{undefined}</li>
            <li>{null}</li>
        </ul>

        <h2>Object, Array 값</h2>

        <ul>
            {
                Object.keys(loginUser).map((key) => 
                <li key={key}> {/*} 반복되는 요소 안에는 무조건 key라는 속성이 필요함 */}
                    {key} : {loginUser[key]}
                        
                </li>)}
                <li>{numbers}</li> {/* 배열 그대로 출력(문자열로 자동 변환) */}
                [<li key={1}>111</li>, <li key={2}>222</li>,<li key={3}>333</li>]

        </ul>

        <h2>태그 속성에 값 넣기</h2>
        <ul>
            <li>
                <img src="imgUrl" alt="빵빵이"></img>
            </li>
        </ul>

        <h2>조건부 렌더링</h2>

        {/* <li>{isLoading ? <로딩바> : <ui></ui></li> */}
        <ul>
            <li>{num > 10 ? "10보다 큼" : "10보다 작음"}</li>
            <li>{num == 10 && "조건이 true일 때 보임"}</li>
            <li>{num > 10 || "조건이 true일 때 안보임"}</li>
       
        <h3>삼항 연산자</h3>
        <li>{1 + 1 === 2 ? "참입니다." : "거짓입니다."}</li>
    
        <h3>AND 연산자</h3>
            <li>{1+1 === 2 && "AND연산자 1"}</li>
            <li>{1+1 !== 2 && "AND연산자 1"}</li>
            <li>{userList.length !== 0 && "user목록"}</li>


        <h3>OR 연산자</h3> 
        <li>{1+1 !== 2 || "OR연산자1"}</li>   
        <li>{1+1 !== 2 || "OR연산자1"}</li>   
        </ul>
    
        <h2>함수 호출로 태그가 올 수 있음</h2>
        <ul>
            <li>{getImg()}</li>
        </ul>

        <h2>배열을 이용한 동적 리스트 가져오기</h2>
        <ul>
            <li>이름 : 최지원,  id : jiwon001, age: 50</li>
            {userList.map((user) => <li key={user.id}> 이름:{user.name}, id:{user.id}, age:{user.age}</li>)}
        </ul>{/* 동적으로 ui생성시시 react가 변경 항목만을 식별하기 위해 key속성이 필요함 */}
       

    </div>
  )
}

export default JavaScript