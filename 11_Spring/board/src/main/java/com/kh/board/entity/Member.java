package com.kh.board.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    private String email;
    private String password;
    private String nickName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
