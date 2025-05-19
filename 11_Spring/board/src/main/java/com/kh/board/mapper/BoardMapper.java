package com.kh.board.mapper;

import com.kh.board.controller.dto.request.BoardRequest;
import com.kh.board.controller.dto.response.BoardResponse;
import com.kh.board.entity.Board;
import java.util.List;

import com.kh.board.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface BoardMapper {
    List<Board> findAll();

    int insertBoard(Board board, String upFile);

    Board selectBoard(@Param("boardId") Long boardId);

    Member selectNickName(@Param("email") String email);

    int update(Board board);
}