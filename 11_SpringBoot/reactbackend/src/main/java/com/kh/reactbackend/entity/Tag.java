
package com.kh.reactbackend.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAG_ID")
    private Long tagId;

    @Column(name = "TAG_NAME", length = 30, nullable = false, unique = true)
    private String tagName;
} 
