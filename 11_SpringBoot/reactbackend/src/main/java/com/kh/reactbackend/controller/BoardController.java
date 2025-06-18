package com.kh.reactbackend.controller;

import com.kh.reactbackend.dto.BoardDto;
import com.kh.reactbackend.dto.PageResponse;
import com.kh.reactbackend.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    /*
    page 보고자하는 페이지 번호
    size 몇개씩 가지고 올것인지
    sort 정렬 기준 : 속성, 방향 (boardTitle,desc)
     */

    //boardList 가져오는 용도
    @GetMapping
    public ResponseEntity<PageResponse<BoardDto.Response>> getBoards(
            @RequestParam(required = false) String keyword,
            @PageableDefault(size = 5, sort = "createDate", direction = Sort.Direction.DESC) Pageable pageable) {


        Page<BoardDto.Response> result;
        if (keyword == null || keyword.isBlank()) {
            result = boardService.getBoardList(pageable);
            System.out.println("11111");
        } else {
            result = boardService.searchBoards(keyword, pageable);
            System.out.println("keyWord: " + keyword);
            System.out.println("2222");
            System.out.println(pageable);
        }

            return ResponseEntity.ok(new PageResponse<>(result));
    }

    //boardNo로 보드 조회하기
    @GetMapping("/{id}")
    public ResponseEntity<BoardDto.Response> getBoard(@PathVariable("id") Long boardNo) {
        return ResponseEntity.ok(boardService.getBoardDetail(boardNo));
    }

    //board 게시글 등록
    @PostMapping
    public ResponseEntity<Long> createBoard(@ModelAttribute BoardDto.Create boardCreate) throws Exception {

        return ResponseEntity.ok(boardService.createBoard(boardCreate));
    }

        //board 게시글 삭제
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteBoard(@PathVariable("id") Long boardNo) {

            System.out.println("Delete Board::::" + boardNo);
            boardService.deleteBoard(boardNo);
            return ResponseEntity.ok().build();
        }

    //board 게시글 수정
    @PatchMapping("/{id}")
    public ResponseEntity<BoardDto.Response> updateBoard(@PathVariable("id") Long boardNo, @ModelAttribute BoardDto.Update updateBoard) throws IOException {
        System.out.println("updateBoard:::"+boardNo);
        System.out.println("updateBoard:::"+updateBoard);
        return ResponseEntity.ok(boardService.updateBoard(boardNo, updateBoard));

    }


//    //board 검색
//    @GetMapping
//    public ResponseEntity<PageResponse<BoardDto.Response>> getBoards(
//            @RequestParam(required = false) String keyword,
//            @PageableDefault(size = 10, sort = "boardNo", direction = Sort.Direction.DESC) Pageable pageable) {
//
//
//        return ResponseEntity.ok(new PageResponse<>(boardService.searchBoards(keyword, pageable)));
//    }
}