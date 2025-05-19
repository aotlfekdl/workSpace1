package com.kh.jpa.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Reply {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REPLY_NO")
    private Long replyNo;

    @Column(name = "REPLY_CONTENT", length = 400, nullable = false)
    private String replyContent;


//
//    @Column(name = "REPLY_WRITER", length = 30, nullable = false)
//    private String replyWriter;

    @Column(name = "CREATE_DATE", nullable = false)
    @CreationTimestamp
    private LocalDateTime createDate;

    @Column(name = "STATUS")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REF_BNO", nullable = false)
    private Board board;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REPLY_WRITER", nullable = false)
    private Member member;
}
