package com.ksd.health.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository<T> {
    T save(T board);
    Optional<T> findBySeq(Long seq);
    Optional<T> findByTitle(String title);
    List<T> findAll();
}
