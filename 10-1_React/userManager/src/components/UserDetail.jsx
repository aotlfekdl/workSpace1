import React from 'react'
import { useUserContext } from './UserContext'
import { useNavigate, useParams } from 'react-router-dom';
import styled from 'styled-components';

const FirstDiv = styled.div`
    background-color: #070435;
    display: flex;
   
    width: 400px;
    justify-content: center;
    gap: 15px;
    margin-top: 30px;
    height: 550px;
  
`
const Ul = styled.ul`

padding: 0;

`
const InDivStyle = styled.div`
    width: 250px;
    border: 1px solid black;
    background-color: #dadada;
    height: 250px;
`

const Li = styled.li`
    width: 100%;
    height: 60px;
    list-style: none;
    display: flex;
    align-items: center;
    justify-content: center;
    padding-top: 10px;
`
const Status = styled.span`
    color : ${(props) => (props.status ? 'black' : 'red')};
    font-weight: bold;
    font-size: 16px;
`
const ButtonStyle = styled.button`
    margin-top: 20px;
    background: #c2c2c2;
    border: 1px solid #dadada;
    cursor: pointer;
    outline: none;
    width: 110px;

    &:hover{
        opacity: 0.9;
    }
`

const ButtonDivStyle = styled.div`
    width: 400px;
    display: flex;
    justify-content: center;
    gap: 30px;
    
   
`

const ImgDiv = styled.div`
    padding-top: 10px;
    padding-bottom: 40px;
`

const ImgStyle = styled.img`
  width: 250px;          
  height: 200px;
  object-fit: cover;      
  display: block;
  margin: 0 auto;        
  border: 1px solid black;
`
const UserDetail = () => {
    const {id} = useParams();
    const {userEnrolls, setUserEnrolls} = useUserContext();
    const navigate = useNavigate();

    const onDelete = () => {
        setUserEnrolls(userEnrolls.filter((u) => u.id !== id));
        navigate('/');
    }

    const onBackPage = () => {
        navigate('/');
    }

    const user = userEnrolls.find((user) => user.id === id);
   

  return (
    <>
    <FirstDiv>
        <Ul>
            <ImgDiv><ImgStyle src={user.imgUrl} alt="" /></ImgDiv>
            <InDivStyle>
            <Li>이름: {user.name}</Li>
            <Li>나이: {user.age}세</Li>
            
            
           <Li>
            <Status status={user.status}>

            {user.status ? "🟢 온라인 상태입니다." : " 🔴 오프라인 상태입니다."}
            </Status>
            </Li>
            </InDivStyle>
        </Ul>
        
    </FirstDiv>
    <ButtonDivStyle>
            <ButtonStyle onClick={() => onDelete()}>
                삭제
            </ButtonStyle>
            <ButtonStyle onClick={() => onBackPage()}>
                뒤로가기
            </ButtonStyle>
            </ButtonDivStyle>
            </>
  )
}

export default UserDetail