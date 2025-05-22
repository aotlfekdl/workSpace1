package com.kh.reactbackend.repository;

import com.kh.reactbackend.entity.Board;
import com.kh.reactbackend.enums.CommonEnums;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BoardRespository {
    Page<Board> findByStatus(CommonEnums.Status status, Pageable pageable);
    Optional<Board> findById(Long id);
    Long save(Board board);

    void delete(Board board);
}
