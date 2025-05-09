import React from 'react';
import styled from 'styled-components';
import { VscArrowSmallLeft } from 'react-icons/vsc';
import { FaRegEdit } from 'react-icons/fa';
import { MdDelete } from 'react-icons/md';

const IconButton = () => {
  return (
    <Wrapper>
      <Title>
        <VscArrowSmallLeft />
        <Button color="gray">
          <FaRegEdit />
          수정
        </Button>
        <Button color="red">
          <MdDelete />
          삭제
        </Button>
      </Title>
    </Wrapper>
  );
};

export default IconButton;

const Wrapper = styled.div`
  padding: 20px;
`;

const Title = styled.h2`
  font-size: 24px;
  display: flex;
  align-items: center;
  margin-bottom: 20px;
`;

const Button = styled.button`
  display: flex;
  align-items: center;
  gap: 12px;
  padding: 10px 14px;
  background: black;
  color: white;
  font-size: 14px;
  border: none;
  border-radius: 8px;
  transition: 0.2s;
  &:hover {
    opacity: 0.9;
  }
`;
