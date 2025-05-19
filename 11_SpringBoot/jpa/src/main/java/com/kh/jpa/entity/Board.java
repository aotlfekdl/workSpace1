package com.kh.jpa.entity;

import com.kh.jpa.enums.CommonEnums;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BOARD_NO")
    private Long boardNo;

    @Column(name = "BOARD_TITLE", length = 100, nullable = false)
    private String boardTitle;

//    @Column(name = "BOARD_WRITER",length = 30, nullable = false)
//    private String boardWriter;

    @Column(name = "BOARD_CONTENT", nullable = false)
    @Lob //@Lob : 대용량 데이터 매핑
    private String boardContent;

    @Column(name = "ORIGIN_NAME", length = 100)
    private String originName;

    @Column(name = "CHANGE_NAME", length = 100)
    private String changeName;

    @Column(name = "COUNT")
    private int count;


    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;



    @Column(name = "STATUS", length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    private  CommonEnums.Status status;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_WRITER", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Reply> replies = new ArrayList<>();

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<BoardTag> boardTags = new ArrayList<>();


    @PrePersist
    private void prePersist() {
        this.createDate = LocalDateTime.now();
        if (this.status == null) {
            this.status = CommonEnums.Status.Y;

        }
    }

}
