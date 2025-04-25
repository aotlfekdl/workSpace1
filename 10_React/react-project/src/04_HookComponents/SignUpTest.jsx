import React, { useState } from 'react'

//이름과 성별을 입력받을 수 있도록 만들고
//submit 버튼 클릭시 이름 : ~~~성별 : ~~를 출력해라.

const SignUpTest = () => {
    const [name, setName] = useState("");
    const [gender, setGender] = useState("man");

    const eventName = (ev) => {
        setName(ev.target.value);

    }

    const eventGender = (ev) => {
        setGender(ev.target.value);
    }

    const eventSubmit = (ev) =>{
        alert(` 이름 : ${name}, 성별 : ${gender}`);
    }


  return (
    <form onSubmit={eventSubmit}>
        <label htmlFor="">
            이름 : 
            <input type="text"  value={name} onChange={eventName}/>
        </label>
        <br /><br />
        <label htmlFor="">성별 : 
            <select vlaue={gender} onChange={eventGender}>
                <option value="man">남자</option>
                <option value="woman">여자</option>
            </select>
        </label>
        <br /><br />
        <button type='submit'>제출</button>

    </form>
)}

export default SignUpTest