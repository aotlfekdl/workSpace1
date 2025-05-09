package com.kh.board.controller.dto.request;


import com.kh.board.entity.Board;
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





        public Board toEntity() {
            return Board.builder()
                    .title(this.getTitle())
                    .contents(this.getContents())
                    .memberEmail(this.getUserId())
                    .build();
        }
    }


}
