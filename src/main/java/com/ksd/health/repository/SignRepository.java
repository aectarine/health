package com.ksd.health.repository;

import com.ksd.health.model.Member;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class SignRepository implements MemberRepository {
    private final EntityManager em;

    public SignRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findBySeq(Long seq) {
        Member member = em.find(Member.class, seq);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByAccount(String account) {
        List<Member> members = em.createQuery("select m from Member m where m.account = :account", Member.class)
                .setParameter("account", account)
                .getResultList();
        return members.stream().findAny();
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
