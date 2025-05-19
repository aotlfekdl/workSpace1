package com.kh.jpa.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)  //JPA 스펙상 필수 + 외부 생성 방지
@Builder
@AllArgsConstructor
@Getter
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROFILE_ID")
    private Long profileId;


    @Column(name = "PROFILE_IMAGE", length = 100)
    private String profileImage;

    @Column(name = "INTRO", length = 300)
    private String intro;


    @OneToOne
    @JoinColumn(name = "USER_ID", unique = true)
    private Member member;

}
