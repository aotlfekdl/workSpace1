package com.kh.board.mapper;

import com.kh.board.controller.dto.request.BoardRequest;
import com.kh.board.entity.Board;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface BoardMapper {
    List<Board> findAll();

    int insertBoard(Board board, String upFile);
}