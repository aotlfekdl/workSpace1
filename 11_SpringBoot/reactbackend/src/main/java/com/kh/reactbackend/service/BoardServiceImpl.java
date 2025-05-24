package com.kh.reactbackend.service;

import com.kh.reactbackend.dto.BoardDto;
import com.kh.reactbackend.entity.Board;
import com.kh.reactbackend.entity.BoardTag;
import com.kh.reactbackend.entity.Member;
import com.kh.reactbackend.entity.Tag;
import com.kh.reactbackend.enums.CommonEnums;
import com.kh.reactbackend.repository.BoardRespository;
import com.kh.reactbackend.repository.MemberRepository;
import com.kh.reactbackend.repository.TagRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardServiceImpl implements BoardService {

    private final BoardRespository boardRespository;
    private final MemberRepository memberRepository;
    private final TagRepository tagRepository;
    private final String UPLOAD_PATH = "C:\\workspace\\11_SpringBoot\\reactbackend\\src\\main\\resources\\static\\uploadFile\\";

    @Override
    public Page<BoardDto.Response> getBoardList(Pageable pageable) {
        Page<Board> page = boardRespository.findByStatus(CommonEnums.Status.Y, pageable);

        return page.map(BoardDto.Response::toSimpleDto);
    }

    @Override
    public BoardDto.Response getBoardDetail(Long boardNo) {
        Board board = boardRespository.findById(boardNo)
                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
        return BoardDto.Response.toDto(board);
    }

    @Transactional
    @Override
    public Long createBoard(BoardDto.Create createBoard) throws Exception {

        Member member = memberRepository.findOne(createBoard.getUser_id())
                .orElseThrow(() -> new RuntimeException("회원을 찾을 수 없습니다."));

        String originName = null;
        String changeName = null;


        //이미 있는 경우
        if(createBoard.getFile() != null && !createBoard.getFile().isEmpty()) {
            originName = createBoard.getFile().getOriginalFilename();

            changeName = UUID.randomUUID().toString()+"_"+originName;

            File uploadFile = new File(UPLOAD_PATH+changeName);
            if(!uploadFile.exists()){
                uploadFile.mkdirs();
            }
            createBoard.getFile().transferTo(new File(UPLOAD_PATH+changeName));
        }

        Board board = createBoard.toEntity();
        board.changeMember(member);
        board.changeFile(originName, changeName);

        if (createBoard.getTags() != null && !createBoard.getTags().isEmpty()) {
            for (String tagName : createBoard.getTags()) {
                Tag tag = tagRepository.findByTagName(tagName)
                        .orElseGet(() -> tagRepository.save(Tag.builder()
                                .tagName(tagName)
                                .build()));

                BoardTag boardTag = BoardTag.builder()
                        .tag(tag)
                .build();

                boardTag.changeBoard(board);
            }
        }
        return boardRespository.save(board);
    }


    @Transactional
    @Override
    public void deleteBoard(Long boardNo) {
        Board board = boardRespository.findById(boardNo)
                        .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        boardRespository.delete(board);

    }

    @Transactional
    @Override
    public BoardDto.Response updateBoard(Long boardNo, BoardDto.Update boardUpdate) throws IOException {
        Board board = boardRespository.findById(boardNo).orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));


        String originName = null;
        String changeName = null;

        if(boardUpdate.getFile() != null && !boardUpdate.getFile().isEmpty()) {
            originName = boardUpdate.getFile().getOriginalFilename();
            changeName = UUID.randomUUID().toString()+"_"+originName;
            File uploadFile = new File(UPLOAD_PATH+changeName);
            if(!uploadFile.exists()){
                uploadFile.mkdirs();
            }
            boardUpdate.getFile().transferTo(new File(UPLOAD_PATH+changeName));
        }
        board.changeFile(originName, changeName);
        board.changeContent(boardUpdate.getBoard_content());
        board.changeTitle(boardUpdate.getBoard_title());
        if (boardUpdate.getTags() != null && !boardUpdate.getTags().isEmpty()) {
            for (String tagName : boardUpdate.getTags()) {
                Tag tag = tagRepository.findByTagName(tagName)
                        .orElseGet(()->tagRepository.save(Tag.builder()
                                        .tagName(tagName)
                                .build()));

                BoardTag boardTag = BoardTag.builder()
                        .tag(tag)
                        .build();

                boardTag.changeBoard(board);
            }
        }
        return BoardDto.Response.toDto(board);
    }



//
//    @Override
//    public Page<BoardDto.Response> getBoardList(Pageable pageable) {
//        /*
//            getContent() 실제 데이터 리스트 반환
//            getTotalPages() 전체 페이지 개수
//            getTotalelements() 전체 데이터 수
//            getSize() 페이지당 데이터 수
//            ...
//         */
//        Page<Board> page = boardRespository.findByStatus(CommonEnums.Status.Y, pageable);
//
//        return page.map(BoardDto.Response::toSimpleDto);
//    }
//
//    @Override
//    public BoardDto.Response getBoardDetail(Long boardNo) {
//        Board board = boardRespository.findById(boardNo)
//                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
//
//        return BoardDto.Response.toDto(board);
//    }
//
//    @Transactional
//    @Override
//    public Long createBoard(BoardDto.Create createBoard) throws IOException {
//        //게시글작성
//        //작성자 찾기 -> 객체지향코드를 작성할 것이기때문에 key를 직접 외래키로 insert하지않고
//        //작성자를 찾아 참조해준다.
//
//        Member member = memberRepository.findOne(createBoard.getUser_id())
//                .orElseThrow(() -> new EntityNotFoundException("회원을 찾을 수 없습니다."));
//
//        String changeName = null;
//        String originName = null;
//
//        if (createBoard.getFile() != null && !createBoard.getFile()
//                .isEmpty()) {
//            originName = createBoard.getFile()
//                    .getOriginalFilename();
//            changeName = UUID.randomUUID()
//                    .toString() + "_" + originName;
//
//            File uploadDir = new File(UPLOAD_PATH);
//            if (!uploadDir.exists()) {
//                uploadDir.mkdirs();
//            }
//
//            createBoard.getFile()
//                    .transferTo(new File(UPLOAD_PATH + changeName));
//        }
//
//        Board board = createBoard.toEntity();
//        board.changeMember(member);
//        board.changeFile(originName, changeName);
//
//        if (createBoard.getTags() != null && !createBoard.getTags()
//                .isEmpty()) {
//            //tag가 왔다.
//            for (String tagName : createBoard.getTags()) {
//                //tag를 이름으로 조회해서 없으면 새로 만들어라.
//                Tag tag = tagRepository.findByTagName(tagName)
//                        .orElseGet(() -> tagRepository.save(Tag.builder()
//                                .tagName(tagName)
//                                .build()));
//
//                BoardTag boardTag = BoardTag.builder()
//                        .tag(tag)
//                        .build();
//
//                boardTag.changeBoard(board);
//            }
//        }
//
//        return boardRespository.save(board);
//    }
//
//    @Transactional
//    @Override
//    public void deleteBoard(Long boardNo) {
//        Board board = boardRespository.findById(boardNo)
//                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
//
//        if (board.getChangeName() != null) {
//            new File(UPLOAD_PATH + board.getChangeName()).delete();
//        }
//
//        boardRespository.delete(board);
//    }
//
//
//    @Transactional
//    @Override
//    public BoardDto.Response updateBoard(Long boardNo, BoardDto.Update boardUpdate) throws IOException {
//        Board board = boardRespository.findById(boardNo)
//                .orElseThrow(() -> new EntityNotFoundException("게시글을 찾을 수 없습니다."));
//
//        String changeName = board.getChangeName();
//        String originName = board.getOriginName();
//
//        if (boardUpdate.getFile() != null && !boardUpdate.getFile()
//                .isEmpty()) {
//            originName = boardUpdate.getFile()
//                    .getOriginalFilename();
//            changeName = UUID.randomUUID()
//                    .toString() + "_" + originName;
//
//            File uploadDir = new File(UPLOAD_PATH);
//            if (!uploadDir.exists()) {
//                uploadDir.mkdirs();
//            }
//
//            boardUpdate.getFile()
//                    .transferTo(new File(UPLOAD_PATH + changeName));
//        }
//
//        board.changeContent(boardUpdate.getBoard_content());
//        board.changeTitle(boardUpdate.getBoard_title());
//        board.changeFile(originName, changeName);
//
//        if (boardUpdate.getTags() != null && !boardUpdate.getTags()
//                .isEmpty()) {
//            //기존BoardTag -> 연결이 끊기면 필요가 있을까? X
////            for (BoardTag boardTag : board.getBoardTags()) {
////                boardTagRepository.delete(boardTag);
//            //연결된 boardTags의 영속성을 제거한다. -> orphanRemoval = true 설정이 되어있다면 db에서 제거
//            board.getBoardTags().clear();
////            }
//            //tag가 왔다.
//            for (String tagName : boardUpdate.getTags()) {
//                //tag를 이름으로 조회해서 없으면 새로 만들어라.
//                Tag tag = tagRepository.findByTagName(tagName)
//                        .orElseGet(() -> tagRepository.save(Tag.builder()
//                                .tagName(tagName)
//                                .build()));
//
//                BoardTag boardTag = BoardTag.builder()
//                        .tag(tag)
//                        .build();
//
//                boardTag.changeBoard(board);
//            }
//        }
//
//        return BoardDto.Response.toDto(board);
//    }


}