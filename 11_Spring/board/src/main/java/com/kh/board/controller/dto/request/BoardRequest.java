package com.kh.board.controller.dto.request;


import com.kh.board.entity.Board;
import com.kh.board.entity.Member;
import lombok.*;

import javax.swing.*;
import java.time.LocalDateTime;


public class BoardRequest {

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static class SimpleDTO{

        private String title;
        private String contents;
        private String userId;

        public Board toEntity(Member member) {
            return Board.builder()
                    .title(this.getTitle())
                    .contents(this.getContents())
                    .member(member)
                    .build();
        }
    }

    @Setter
    @Getter
    public static class updateDTO{
        private Long boardId;
        private String title;
        private String contents;
        private String user_id;
        private String origin_file;



        public Board toEntity(Member member) {
            return Board.builder()
                    .boardId(boardId)
//                    .memberEmail(user_id)
                    .title(title)
                    .contents(contents)
                    .fileName(origin_file)
                    .build();
        }
    }


}
