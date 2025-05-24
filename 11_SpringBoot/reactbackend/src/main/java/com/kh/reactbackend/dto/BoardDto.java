package com.kh.reactbackend.dto;

import com.kh.reactbackend.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

public class BoardDto {

    @Getter
    @AllArgsConstructor
    public static class Update{
        private String board_title;
        private String board_content;
        private MultipartFile file;
        private List<String> tags;

        public Board toEntity(){
            return Board.builder()
                    .boardTitle(this.board_title)
                    .boardContent(this.board_content)
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    public static class Create{
        private String board_title;
        private String board_content;
        private String user_id;
        private MultipartFile file;
        private List<String> tags;

        public Board toEntity(){
            return Board.builder()
                    .boardTitle(this.board_title)
                    .boardContent(this.board_content)
                    .build();
        }
    }

    @Getter
    @AllArgsConstructor
    public static class getBoard {
        private Long board_no;
        private String board_title;
        private String user_id;
        private MultipartFile file;


    }



    @Getter
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long board_no;
        private String board_title;
        private String board_content;
        private String origin_name;
        private String change_name;
        private LocalDateTime create_date;
        private Integer count;
        private String user_id;
        private String user_name;
        private List<String> tags;

        public static Response toDto(Board board) {
            return Response.builder()
                    .board_no(board.getBoardNo())
                    .board_title(board.getBoardTitle())
                    .board_content(board.getBoardContent())
                    .change_name(board.getChangeName())
                    .origin_name(board.getOriginName())
                    .count(board.getCount())
                    .create_date(board.getCreateDate())
                    .user_id(board.getMember()
                            .getUserId())
                    .user_name(board.getMember()
                            .getUserName())
                    .tags(board.getBoardTags()
                            .stream()
                            .map(boardTag -> boardTag.getTag()
                                    .getTagName())
                            .toList())
                    .build();
            //boardTag x boardTag가 여러개이기 때문에 하나마다 전부 -> tag추출
        }

        public static Response toSimpleDto(Board board) {
            return Response.builder()
                    .board_no(board.getBoardNo())
                    .board_title(board.getBoardTitle())
                    .origin_name(board.getOriginName())
                    .count(board.getCount())
                    .create_date(board.getCreateDate())
                    .change_name(board.getChangeName())
                    .user_id(board.getMember()
                            .getUserId())
                    .build();
        }
    }
}
