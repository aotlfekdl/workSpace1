import React from 'react'
import { useForm } from 'react-hook-form';
import styled from 'styled-components'
import * as yup from "yup";
import { yupResolver } from '@hookform/resolvers/yup';


const schema = yup.object().shape({
    name: yup.string().required('이름을 입력하세요'),
    email: yup.string.email('유효한 이메일 형식이 아닙니다.').required('이메일을 입력하세요'),

})

const SimpleForm = () => {
    const {
        register,
        handleSubmit,
        formState: {errors},
    } = useForm({
        resolver: yupResolver(schema),
    });
    const onSubmit = (data) =>{
        alert(`입력성공 ! 이름: ${data.name}, 이메일 : ${data.email}`)
    }

  return (
    <FormWrapper onSubmit={handleSubmit(onSubmit)}>
        <label>이름</label>
        <input type='text' {...register('name')}/>
        {errors.name && <ErrorText>{errors.name.message}</ErrorText>}

        <label>이메일</label>
        <input type='email' {...register('email')}/>
        {errors.email && <ErrorText>{errors.eamil.message}</ErrorText>}

        <button type='submit'>제출</button>


    </FormWrapper>
  )
}

export default SimpleForm

const FormWrapper = styled.form`
    display: flex;
    flex-direction: column;
    gap: 12;
    padding: 18px;
    max-width: 600px;
    margin: 0auto;

    input{
        padding: 8px;
        border: 1px solid black;
        border-radius: 4px;
    }

    button{
        padding: 10px;
        background: blueviolet;
        color: wheat;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

`;

const ErrorText = styled.p`
    font-size: 12px;
    color: red;

`