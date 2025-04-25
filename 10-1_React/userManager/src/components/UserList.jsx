import React from 'react';
import { useUserContext } from './UserContext';
import styled from 'styled-components';
import { useNavigate } from 'react-router-dom';
import { useTheme } from '../context/ThemeContext';
// import { useTheme } from './context/ThemeContext';

const Li = styled.li`
    list-style: none;

`  

const ImgStyle = styled.img`
  width: 150px;          
  height: 150px;
  border-radius: 50%;     
  object-fit: cover;      
  display: block;
  margin: 0 auto;        
  border: 1px solid black;

`
const ImgDiv = styled.div`
    padding-bottom: 10px;
`
const ListDivStyle = styled.div`
  
  display: grid;
  grid-template-columns: repeat(4, 1fr); 
  gap: 20px;
  padding: 20px;
  justify-items: center;
`;

const ProfileDiv = styled.div`
  width: 200px;
  height: 260px;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 12px;
  text-align: center;
  transition: 0.3s;
  cursor: pointer;
  background: ${({theme}) => theme === "white" ? "#e92929" : "#357e7e7b"};
  &:hover {
    transform: translateY(-4px);
    background-color: #f1f1f1;
  }
`;

const Ul = styled.ul`
  padding: 10px;
  width: 200px;
  height: 260px;
  border: 1px solid #ccc;
  border-radius: 12px;
  cursor: pointer;
  text-align: center;
  transition: all 0.3s;
  

  &:hover {
    background-color: #f1f1f1;
    transform: translateY(-3px);
  }
`
const FirstDiv = styled.div`
  width: 100%;
  height: 100vh;
  margin-top: 80px;
`

const UserList = () => {
    const {theme, toggleTheme} = useTheme();
    const {userEnrolls} = useUserContext();
    
    const navigate = useNavigate();

    const onClickEvent = (user) => {
    
        navigate(`/user/${user.id}`);
   
    }

  return (
    <FirstDiv>
      
      <h3>{userEnrolls.length === 0 ? "등록된 사용자가 없습니다." : "등록된 사용자 목록"}</h3>
 
      <ListDivStyle as="ul">
  {userEnrolls.map((user, idx) => (
    <li key={idx} onClick={() => onClickEvent(user)} style={{ listStyle: 'none' }}>
      <ProfileDiv>
        <ImgStyle src={user.imgUrl} alt={user.name} />
        <div>이름: {user.name}</div>
        <div>나이: {user.age}세</div>
        <div>상태: {user.status ? "온라인" : "오프라인"}</div>
      </ProfileDiv>
    </li>
  ))}
</ListDivStyle>
    </FirstDiv>
  );
};

export default UserList;
