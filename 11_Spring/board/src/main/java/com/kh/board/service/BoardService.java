package com.kh.board.service;

import com.kh.board.controller.dto.request.BoardRequest;
import com.kh.board.entity.Board;
import com.kh.board.entity.Member;
import org.springframework.http.RequestEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {
    List<Board> findAll();


    int insertBoard(Board board, String upFile);
//    List<Board> insertBoard(RequestEntity<List<BoardRequest.SimpleDTO>> requestEntity);
}