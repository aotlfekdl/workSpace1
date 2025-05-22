package com.kh.reactbackend.entity;

import com.kh.reactbackend.enums.CommonEnums;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) //JPA 스펙상 필수 + 외부 생성 방지
@AllArgsConstructor
@Builder
@DynamicInsert// insert시에 null이 아닌 필드만 쿼리에 포함, default값 활용
@DynamicUpdate// 변경된 필드만 update문에 포함
public class Member {

    @Id
    @Column(name = "USER_ID", length = 30)
    private String userId;

    @Column(name = "USER_PWD", length = 100, nullable = false)
    private String userPwd;

    @Column(name = "USER_NAME", length = 15, nullable = false)
    private String userName;

    @Column(length = 254)
    private String email;

    @Column(name = "GENDER", length = 1)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 13)
    private String phone;



    @Column(name = "ENROLL_DATE")
    private LocalDateTime enrollDate;

    @Column(name = "MODIFY_DATE")
    private LocalDateTime modifyDate;

    @Column(length = 1, nullable = false)
    @Enumerated(EnumType.STRING)
    private CommonEnums.Status status;


    @Column(length = 1, nullable = false, name = "ISDELETED")
    @Enumerated(EnumType.STRING)
    private isDeleted isDeleted;


    //1 : N 연관관계 주인 = Board
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<Board> boards = new ArrayList<>();

    //1 : N 연관관계 주인 = Notice
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    List<Notice> notices = new ArrayList<>();

    //회원 : 프로필 (1 : 1)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFILE_ID", unique = true)
    private Profile profile;


    public enum Gender {
        M, F
    }
    public enum isDeleted {
        Y, N
    }

    public void updateMemberInfo(String userName, String email, Gender gender, String phone) {
        this.userName = userName;
        this.email = email;
        this.gender = gender;
        this.phone = phone;


    }

    @PrePersist
    public void prePersist() {
        this.enrollDate = LocalDateTime.now();
        this.modifyDate = LocalDateTime.now();
        if(this.status == null) {
            this.status = CommonEnums.Status.Y;
        }
        if(this.isDeleted == null) {
            this.isDeleted = isDeleted.N;
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.modifyDate = LocalDateTime.now();
    }
}