import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import JavaScript from './components/JavaScript'
import Style from './components/Style'
import Products from './components/Products'
import Hello from './components/Hello'
import Heading from './components/Heading'
import VideoList from './components/VideoList'
import LifecycleText from './03_components/LifecycleText'
import Comment from './03_components/Comment'
import UseStateTest from './04_HookComponents/UseStateTest'
import SignUp from './04_HookComponents/SignUp'
import LandingPage from './04_HookComponents/LandingPage'
import Toolbar from './04_HookComponents/Toolbar'
import SignUpTest from './04_HookComponents/SignUpTest'
import UseRefTest from './05_uesRefComponents/UseRefTest'
import UseRefScroll from './05_uesRefComponents/UseRefScroll'
import LandingPageTest from './04_HookComponents/LandingPageTest'
import UseMemoTest from './06_useMemo/UseMemoTest'
import UseCallbackTest from './07_useCallback/UseCallbackTest'
import UseEffectTest from './08_useEffect/UseEffectTest'
import EffectView from './08_useEffect/EffectView'
import BlackOrWhite from './09_useContext/BlackOrWhite'
import MyForm from './10_customHook/MyForm'
import ToggleBox from './10_customHook/ToggleBox'
import { UserProvider } from './09_useContext/UserContext'
import Header from './09_useContext/Header'
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom'
import Profile from './pages/Profile'
import Home from './pages/Home'
import NotFound from './pages/NotFound'
import About from './pages/About'

// const videoData = [{
//   sumbnail:"https://i.ytimg.com/an_webp/ugR9MOkqK_g/mqdefault_6s.webp?du=3000&sqp=CKi9h8AG&rs=AOn4CLCHATRFJmBeirLG2dsfaKqEhEvgGw",
//   title: "빵빵이와 옥지의 진솔한 대화(물리)",
//   logo: "https://yt3.ggpht.com/wYRkjS6E0mMZ-np2jNwjVaCNzQMpxs1VkdQ_p25oe0aaSj0awd7f9xRUcrwI6rVOQE7kjZQ6l4A=s48-c-k-c0x00ffffff-no-rj",
//   channelName: "빵빵이의 일상",
//   views: '8.3만',
//   date: "2시간 전",
// },{
//   sumbnail:"https://i.ytimg.com/an_webp/ugR9MOkqK_g/mqdefault_6s.webp?du=3000&sqp=CKi9h8AG&rs=AOn4CLCHATRFJmBeirLG2dsfaKqEhEvgGw",
//   title: "빵빵이와 옥지의 진솔한 대화(물리)",
//   logo: "https://yt3.ggpht.com/wYRkjS6E0mMZ-np2jNwjVaCNzQMpxs1VkdQ_p25oe0aaSj0awd7f9xRUcrwI6rVOQE7kjZQ6l4A=s48-c-k-c0x00ffffff-no-rj",
//   channelName: "빵빵이의 일상",
//   views: '8.3만',
//   date: "2시간 전",
// }]



function App() {
  // const [isButton, setIsButton] = useState(true);
  // const toggleButton = () =>{
  //   setIsButton(!isButton);
  // }
  return (
    <>
      {/* <JavaScript /> */}
      {/* <Style /> */}
      {/* <Products/> */}
      {/* <Heading type="h2"/> */}
      {/* <Heading> */}
        {/* 무엇을 도와드릴까요? */}
      {/* </Heading> */}
      {/* <Hello/> */}
     {/* <VideoList videos={videoData}/> */}
{/* 
      {isButton && <LifecycleText/>}
      <button onClick={toggleButton}>count없애기기</button> */}
      {/* <Comment message={"안녕하세요"} /> */}
      {/* <SignUpTest /> */}
    {/* <LandingPageTest /> */}
    < UseRefScroll/>
      {/* <UseRefTest /> */}
      {/* <SignUpTest/> */}
        {/* <UseMemoTest/> */}
        {/* <UseCallbackTest /> */}
        {/* <EffectView> */}
        {/* <BlackOrWhite/> */}
        {/* <MyForm/> */}
        {/* <ToggleBox/> */}
        {/* <UserProvider>
        <Header />
        </UserProvider> */}
        {/* <BrowserRouter>
        <nav>
          Link : a태그와 동일한 역할을 하지만 react-router-dom을 활용해 SPA방식으로 자연스럽게 화면전환
          <Link to={"/"} style={{margin:12}}>홈</Link>
          <Link to={"/about"} style={{margin:12}}>소개</Link>
          <Link to={"/profile/최지원"} style={{margin:12}}>프로필</Link>
        </nav>
        <Routes>
          <Route path='/' element={<Home />}/>
          <Route path='about/' element={<About />}/>
          <Route path='profile/:username' element={<Profile />}/>
          <Route path='*' element={<NotFound />}/>
        </Routes>
        </BrowserRouter> */}





    </>

  )
}

export default App
