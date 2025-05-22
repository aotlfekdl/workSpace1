package com.kh.reactbackend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) //JPA 스펙상 필수 + 외부 생성 방지
@AllArgsConstructor
@Builder
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTICE_NO")
    private Long noticeNo;

    @Column(name = "NOTICE_TITLE", length = 30, nullable = false)
    private String noticeTitle;

    @Column(name = "NOTICE_CONTENT", length = 200, nullable = false)
    private String noticeContent;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    //공지 : 작성자(N : 1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "NOTICE_WRITER")
    private Member member;

    @PrePersist
    protected void onCreate() {this.createDate = LocalDateTime.now();}

    public void updateNoticeInfo(String noticeTitle, String noticeContent) {
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
    }
}