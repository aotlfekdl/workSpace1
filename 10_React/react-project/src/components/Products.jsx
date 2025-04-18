import React from 'react'
import styled from 'styled-components'


const TableStyle = styled.table`
    border: 1px solid black;
    width: 400px;
    height: 100px;
`

const TableTHead = styled.th`
  border: 1px solid red;
`

const Td = styled.td`
  border: 1px solid black;
`

const Tr = styled.tr`
  &:hover{
    background-color: #f1f1f1;
  }
`



const productItems = [{
  product_name : "삼성 TV",
  price :  10000,
  color :  "블랙"
},{
  product_name : "엘지 냉장고",
  price :  30000,
  color :  "베이지"
},{
  product_name : "애플 노트북",
  price :  50000,
  color :  "그레이"
}]


const Products = () => {
  return (
    <div>
      <TableStyle>
      
        <thead>
          <tr>
            <TableTHead>제품명  </TableTHead>
            <TableTHead>가격  </TableTHead>
            <TableTHead>색상  </TableTHead>
          </tr>
        </thead>
        <tbody>
        
         
          {productItems.map((product) => 
          <Tr>
          <Td>{product.product_name}</Td>
          <Td>{product.price}</Td>
          <Td>{product.color}</Td>
          
          </Tr>
          )}
          
        </tbody>
   
      </TableStyle>
    </div>
  )
}

export default Products