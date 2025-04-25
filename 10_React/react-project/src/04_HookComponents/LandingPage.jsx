import React from 'react'
import Toolbar from './Toolbar'
import Grade from './Grade'
import { useState } from 'react';


/*
    여러 컴포넌트에서 사용하는 데이터를 상위 컴포넌트에 state로 저장하고 이를 props로 하위 컴포넌트에 전달한다.
    또한 state 변경 함수는 상위 컴포넌트에서 정의하고, 하위 컴포넌트에서
    직접 setState를 사용하지 않도록 한다. */


const LandingPage = () => {
    const [isLogin, setIsLoging] = useState(false);

    const onClickLpgin = () => {
        setIsLoging(true);
    } 

    const onClickLogout = () =>{
        setIsLoging(false);
    }
    return (
        <div>
            <Toolbar
                isLogin={isLogin}
                onClickLogin = {onClickLpgin}
                onClickLogout = {onClickLogout}
                />
            <Grade isLogin={isLogin} />
            </div>
    )
}
export default LandingPage