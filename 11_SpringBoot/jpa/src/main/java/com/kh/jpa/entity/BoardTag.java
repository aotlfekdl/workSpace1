package com.kh.jpa.entity;

import lombok.*;
import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "BOARD_TAG")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardTag {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_NO", insertable = false, updatable = false)
    private Board board;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAG_ID", insertable = false, updatable = false)
    private Tag tag;
}
