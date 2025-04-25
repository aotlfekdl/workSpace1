import React, { useState, useMemo, useCallback } from 'react'
import ViewItem from './ViewItem';

const UseCallbackTest = () => {
const [num, setNum] = useState(1);
const [dark, setDark] =useState(false);
const getItems = useCallback(() => num ? [num, num+1, num+2] : [0,0,0], [num]);// getItems함수를 메모이제이션(기억) 하는 것 num이 바뀔때만 새로 생성되고 바뀌지 않으면 이전 함수 재사용용

//useCallback으로 함수 캐싱함함
const theme = useMemo(()=>({
    backgroundColor: dark ? "#333" : "#fff",
    color : dark ? "#fff" : "#333",
    padding: "12px",
}), [dark])


//parseInt JavaScript에서 문자열을 정수로 바꾸는 함수
//parseInt가 왜 쓰였나?? -> input요소에서 받아오는 값은 항상 문자열(String)이기 때문에
//ex) input요소에서 들어오는 num은 1 이 아닌 문자열 "1" 이기 때문에 사용용

const onChangeNum = (ev) => {
    setNum(parseInt(ev.target.value));
}

  return (
    <div style={theme}>
        <h2>useCallback 테스트</h2>
        <input type="text"
        value={num}
        onChange={onChangeNum}
        />

        <button onClick={() => setDark(prev => !prev)}>
            테마 변경
        </button>
        <ViewItem getItems={getItems}/>

    </div>


  )
}


export default UseCallbackTest