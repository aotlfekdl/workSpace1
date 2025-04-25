import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import UserList from './UserList';
import { useUserContext } from './UserContext';
import styled from 'styled-components';
import './UserRegistration.css'
const FromStyle = styled.form`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: end;

    gap: 20px;
    width: 400px;
     
`
const LabelStyle = styled.label`
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    gap: 10px;
`

const FirstDiv = styled.div`
    background: #c0bebe;
    width: 500px;
    height: 500px;
    display: flex;
    justify-content: center;
    margin-top: 80px;

    padding-top: 0;
`
const InputStyle = styled.input`
    height: 30px;
    width: 200px;
    border: 1px solid #bdbcbc;
    border-radius: 8px;
`

const Row = styled.div`
  display: flex;
  align-items: center;
  gap: 10px;
`
const UlStyle = styled.ul`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: end;
    margin-right: 20%;
    width: 400px;
`
const LiStyle = styled.li`
    height: 60px;
    gap: 20px;
    list-style: none;
`
const SpanStyle = styled.span`
    color: red;
    font-size: 14px;
    margin: 0px;
    
`

const UserRegistration = () => {
    const [id, setId] = useState("");
    const [name, setName] = useState("");
    const [age, setAge] = useState("");
    const [status, setStatus] = useState(false);
    const [imgUrl ,setImgUrl] = useState("");
    const { userEnrolls, setUserEnrolls } = useUserContext();
    
    const [error, setErrors] = useState({});

   

    const eventChangeId = (ev) => {
        setId(ev.target.value);
    }

    const eventChangeName = (ev) => {
        setName(ev.target.value);
    }

    const enventChangeAge = (ev) =>{
        setAge(ev.target.value);
    }
    const enventChangeImage = (ev) => {
        setImgUrl(ev.target.value);
    }
    
    const eventChangeStatus = (ev) => {
        setStatus(ev.target.value === 'true')
    }

    const validate = () => {
        const newErrors = {};
        if(!id.trim()){
            newErrors.id = '아이디를 입력해주세요';
        }
        if(!name.trim()){
            newErrors.name = '이름을 입력해주세요';
        }
        if(!age.trim()){
            newErrors.age = '나이를 입력해주세요';
        }
        
        return newErrors;
    };

   

    const navigate = useNavigate();


    const handleSubmit = (ev) => {
        
        
        ev.preventDefault()
        const newErrors = validate();
        if(Object.keys(newErrors).length === 0){
        const userEnroll = {
            id : id,
            name : name,
            age : age,
            status : status,
            imgUrl : imgUrl,
        }
        setUserEnrolls([...userEnrolls, userEnroll]);
        
        navigate('/');
        }else{
            setErrors(newErrors);
        }

        



        
    }

    // const navigate = useNavigate();


  return (
    <div>
    <FirstDiv>
    <FromStyle onSubmit={handleSubmit}>
    <UlStyle>
        <LiStyle>
        <LabelStyle htmlFor="">
          아이디 
            <InputStyle type="text" value={id} onChange={eventChangeId} />
        </LabelStyle>
        {error.id && <spanSpanStyle style={{ color: 'red', fontSize: '14px', margin: '0px' }}>{error.id}</spanSpanStyle>}
        </LiStyle>
        <LiStyle>
        <LabelStyle htmlFor="">
        이름 
            <InputStyle type="text" value={name} onChange={eventChangeName} />
        
        </LabelStyle>
        {error.name && <SpanStyle style={{ color: 'red', fontSize: '14px', margin: '0px' }}>{error.name}</SpanStyle>}
        </LiStyle>
        <LiStyle>
        <LabelStyle htmlFor="">
        나이 
            <InputStyle type="number" value={age} onChange={enventChangeAge}/>
        </LabelStyle>
        {error.age && <SpanStyle style={{ color: 'red', fontSize: '14px'  }}>{error.age}</SpanStyle>}
        </LiStyle>
        <LiStyle>
        <LabelStyle htmlFor="">
        이미지 URL 
            <InputStyle type="text" value={imgUrl} onChange={enventChangeImage}/>
        </LabelStyle>
       
        </LiStyle>
       
        <label htmlFor="" id='statusLabel'>
          
        상태 
            <select value={status} onChange={eventChangeStatus}>
                <option value={true}>온라인</option>

                <option value={false}>오프라인</option>
            </select>
        </label>
        
        <button type='submit'>등록</button>       
     
        </UlStyle>
        
    </FromStyle>
    </FirstDiv>
    </div>
  )
  

}

export default UserRegistration