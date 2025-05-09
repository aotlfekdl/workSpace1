import React from 'react'
import styled from 'styled-components'
import useCountStore from '../store/useCountStore'


const DisplayContainer = styled.div`
    font-size: 32px;
    margin: 16px;
    border-radius: 8px;
`

const CountText = styled.span`
    font-weight: bold;
`

 

const CountDisplay = () => {
    // const count = useCountStore((state) => state.count);
    
     const {count} = useCountStore();

  return (
    <DisplayContainer>
        현재 카운트 : <CountText>{ count }</CountText>
    </DisplayContainer>
  )
}

export default CountDisplay