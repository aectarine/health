package com.ksd.health.repository;

import com.ksd.health.model.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/** Spring Data JPA를 이용한 처리 */
@Repository
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findBySeq(Long seq);
    Optional<Member> findByAccount(String account);
    Optional<Member> findByEmail(String email);
    List<Member> findAll();
}
