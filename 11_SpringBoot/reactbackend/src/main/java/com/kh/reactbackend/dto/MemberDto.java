package com.kh.reactbackend.dto;

import com.kh.reactbackend.entity.Member;
import com.kh.reactbackend.enums.CommonEnums;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

public class MemberDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create{
        private String user_id;
        private String user_pwd;
        private String user_name;
        private String email;
        private String phone;
        private MultipartFile file;
        private Member.isDeleted isDeleted;

        public Member toEntity() {
            return Member.builder()
                    .userId(this.user_id)
                    .userPwd(this.user_pwd)
                    .userName(this.user_name)
                    .email(this.email)
                    .phone(this.phone)
                    .isDeleted(this.isDeleted)
                    .build();
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response{
        private String user_id;
        private String user_name;
        private String email;
        private String phone;
        private String origin_name;
        private String change_name;
        private Member.isDeleted isDeleted;
        private LocalDateTime enrollDate;
        private LocalDateTime modifyDate;
        private CommonEnums.Status status;

        public static Response toDto(Member member) {
            return Response.builder()
                    .user_id(member.getUserId())
                    .user_name(member.getUserName())
                    .email(member.getEmail())
                    .phone(member.getPhone())
                    .change_name(member.getChangeName())
                    .origin_name(member.getOriginName())
                    .isDeleted(member.getIsDeleted())
                    .enrollDate(member.getEnrollDate())
                    .modifyDate(member.getModifyDate())
                    .status(member.getStatus())
                    .build();
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Update{

        private String user_name;
        private String user_pwd;
        private String email;
        private String phone;
        private MultipartFile file;
        private CommonEnums.Status status;

        public Member toEntity() {
            return Member.builder()

                    .userPwd(this.user_pwd)
                    .userName(this.user_name)
                    .email(this.email)
                    .phone(this.phone)
                    .status(this.status)
                    .build();
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class IsDeleted{
        private Member.isDeleted isDeleted;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class login{
        private String user_id;
        private String user_pwd;

        public Member toDto(Member member) {
            return Member.builder()
                    .userId(this.user_id)
                    .userPwd(this.user_pwd)
                    .build();
        }
    }

    @Builder
    @Getter
    @AllArgsConstructor
    public static class MemberLoginResponse { //여기도 파일 하나 추가하기
        private String user_id;
        private String user_name;
        private String email;
        private String change_name;
        private String phone;
        private String origin_name;
        private CommonEnums.Status status;

        public static MemberLoginResponse toDto(Member member) {
            return MemberLoginResponse.builder()
                    .user_id(member.getUserId())
                    .user_name(member.getUserName())
                    .email(member.getEmail())
                    .change_name(member.getChangeName())
                    .phone(member.getPhone())
                    .origin_name(member.getOriginName())
                    .status(member.getStatus())
                    .build();
        }
    }
}