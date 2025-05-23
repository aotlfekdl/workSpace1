import React, { useState, useEffect } from 'react'

const UseEffectTest = () => {
    const [name, setName] = useState("김개똥");
    const [num, setNum] = useState(0);

    const handleChangeName = (ev) => {
        setName(ev.target.value);
    }

    const handleClickNum = () => {
        setNum(prev => prev+1);
    }

    //1. 배열이 없을 때
    useEffect(() => {
        console.log("1번) 의존성 없음 : 모든 렌더링마다 실행됨")
    })

    //2. 빈 배열을 의존성으로 설정했을 떄
    useEffect(() => {
        console.log("2번) 빈 배열을 의존성으로 설정했을 떄 : 컴포넌트가 마운트 될 때 1번만 실행")
    }, [])


    //3. 의존성배열에 name을 넣었을 떄
    useEffect(() => {
        console.log("3번) 의존성배열에 name을 넣었을 때 : name이 변경될 때만 실행행");
    }, [name])


    //4. 클린업 함수(컴포넌트가 사라질 때 실행하는 함수) : name이 변경될 떄 이전 값을 정리하거나 언마운트 시 실행
        useEffect(() => {
            return () => {
                console.log(`4번) 컴포넌트가 사라질 때 실행 : ${name}`);
            }
        }, [name])


        //5. 컴포넌트가 완전히 사라질 때 실행하는 함수
        useEffect(() => {
            return () => {
                console.log(`5번) 컴포넌트가 완전히 사라질 때 실행 : ${name}`);
            }
        }, [])


      return (
    <div>
        <h2>useEffect 테스트</h2>
        <p>안녕하세요<strong>{name}</strong>입니다.</p>

        <input 
        type="text"
        onChange={handleChangeName}
        value={name}
        placeholder='이름을 변경해주세요'
         />

         <p>버튼을 <strong>{num}</strong>번 클릭했습니다.</p>
        <button onClick={handleClickNum}>+1 증가</button>


    </div>
  )
}

export default UseEffectTest