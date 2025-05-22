package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.BoardDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;

public interface BoardService {
    Page<BoardDto.Response> getBoardList(Pageable pageable);
    BoardDto.Response getBoardDetail(Long boardNo);
    Long createBoard(BoardDto.Create createBoard)throws Exception;
    void deleteBoard(Long boardNo);
    BoardDto.Response updateBoard(Long boardNo ,BoardDto.Update boardDto) throws IOException;

}
