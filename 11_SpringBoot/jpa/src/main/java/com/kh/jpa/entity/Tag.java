package com.kh.jpa.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TAG_ID")
    private String tagId;


    @Column(name = "TAG_NAME", length = 30, nullable = false, unique = true)
    private String tagName;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL)
    private List<BoardTag> boardTags = new ArrayList<>();
}
