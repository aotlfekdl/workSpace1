package com.kh.board.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "nick_name",nullable = false, length = 100)
    private String nickName;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    //Member : Board = 1: N 관계 (한명의 회원은 여러 게시글을 작성할 수 있음
    //mappedBy  ="member" -> Board 엔티티의 'member' 필드가 외래키 주인임을 의미
    //cascade = CascadeType.ALl  -> 회원 삭제 시 관련 게시글 모두 삭제
    private List<Board> boards = new ArrayList<>();


}
