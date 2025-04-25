import React from 'react';
import './App.css'

import UserList from './components/UserList';
import UserRegistration from './components/UserRegistration';
import UserDetail from './components/UserDetail';
import NotFound from './components/NotFound';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import { UserProvider } from './components/UserContext';
import { ThemeProvider } from './context/ThemeContext';
import { useTheme } from './context/ThemeContext';
import styled from 'styled-components';





const Nav = styled.nav`
    position:  sticky;
    top: 0;
    background: #1cc54f;
    width: 100%;
    z-index: 1000;
    height: 70px;
`
const NavUl = styled.ul`
    display: flex;
    gap: 12px;
    list-style: none;
    padding: 12px;
    justify-content: center;
    align-content: center;
    width: 100%;
    height: 70px;
    margin: 0%;
    padding: 0%;;
`

const LinkStyle = styled.li`
  display: flex;
  align-items: center;
  color: ${({ theme }) => theme.background === "white" ? "black" : "white"};
  &:hover {
 
 opacity: 0.8;
}
`;

const ThemeButton = styled.button`
  background: none;
  border: none;
  color: black;


  padding: 8px;
  display: flex;
  align-items: center;
  justify-content: center;
  outline: none;
  
  &:hover {
 
    opacity: 0.6;
  }
`;


function AppContent() {

  const {theme, toggleTheme} = useTheme();

  return (
  <div style={{
    width: "100%",
    minheight: "100vh",
    display: 'flex',
    flexDirection: 'column',

    alignItems: 'center',
    background: theme,
    color: theme === "white" ? "black" : "white",
}}>
    <UserProvider>

      <BrowserRouter>

        <Nav style={{background: theme === "white" ?  "#1cc54f" : "#15692e",
    color: theme === "white" ? "black" : "white",}}>
        <NavUl>

          <LinkStyle><Link to="/" style={{color: theme === "white" ? "black" : "white",}}>유저 목록 페이지</Link></LinkStyle>
          <LinkStyle><Link to="/user" style={{color: theme === "white" ? "black" : "white",}}>유저 등록 페이지</Link></LinkStyle>
          
        
        <ThemeButton onClick={toggleTheme} style={{color: theme === "white" ? "black" : "white",}}> 
            테마 변경
          </ThemeButton>
        </NavUl>
    </Nav>

        <Routes>
          <Route path="/" element={<UserList />} />
          <Route path="/user" element={<UserRegistration />} />
          <Route path="/user/:id" element={<UserDetail />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </BrowserRouter>
    </UserProvider>
    </div>
  );
}


function App() {
  return (
    <ThemeProvider>
      <UserProvider>
        <AppContent />
      </UserProvider>
    </ThemeProvider>
  );
}
export default App;
