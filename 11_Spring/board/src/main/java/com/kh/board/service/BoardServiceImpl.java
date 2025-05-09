package com.kh.board.service;

import com.kh.board.controller.dto.request.BoardRequest;
import com.kh.board.entity.Board;
import com.kh.board.entity.Member;
import com.kh.board.mapper.BoardMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public List<Board> findAll() { return boardMapper.findAll(); }

    @Override
    public int insertBoard(Board board, String upFile) {
        return boardMapper.insertBoard(board, upFile);
    }


//    @Override
//    public List<Board> insertBoard(RequestEntity<List<BoardRequest.SimpleDTO>> requestEntity) {
//        return List.of();
//    }

}