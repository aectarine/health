package com.ksd.health.repository;

import com.ksd.health.model.HealthBoard;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class HealthBoardRepository implements BoardRepository<HealthBoard> {

    private EntityManager em;

    @Autowired
    public HealthBoardRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public HealthBoard save(HealthBoard board) {
        em.persist(board);
        return board;
    }

    @Override
    public Optional<HealthBoard> findBySeq(Long seq) {
        return Optional.empty();
    }

    @Override
    public Optional<HealthBoard> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public List<HealthBoard> findAll() {
        String jpql = "SELECT hb FROM HealthBoard hb";
        TypedQuery<HealthBoard> list = em.createQuery(jpql, HealthBoard.class);
        return list.getResultList();
    }
}
