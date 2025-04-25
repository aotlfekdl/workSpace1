import React, { useState } from 'react'

const MyForm = () => {
    const name = useInput('');
    const email = useInput('');

  

    const onChangeName = () => {
      setName(ev.target.value);
    }
    
    const onChangeEmail = () => {
      setEmail(ev.target.value);
    }

    const handleSubmit = (e) => {
      e.preventDefault();
      alert(`이름 : ${name.value}, 이메일 : ${email.value}`);
    }


  return (
    <form onSubmit={handleSubmit}>
        <input placeholder='이름...' {...name} />
        <input placeholder='이메일...' {...email}/>
        <button>제출</button>
    </form>
  )
}

export default MyForm