import React, {useState} from 'react'
import ToolbarTest from './ToolbarTest'
import GradeTest from './GradeTest';



const LandingPageTest = () => {

    const [isLogin, setIsLogin] = useState(false);

    const onClickLogin = () => {
        setIsLogin(true);
    }
    const onClickLogout = () => {
        setIsLogin(false);
    }

  return (
 
    <div>
    <ToolbarTest
    isLogin={isLogin}
    onClickLogin={onClickLogin}
    onClickLogout={onClickLogout}
    />
    <GradeTest
    isLogin={isLogin}
    />
    </div>

   
  )
}

export default LandingPageTest