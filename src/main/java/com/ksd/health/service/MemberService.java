package com.ksd.health.service;

import com.ksd.health.model.Member;
import com.ksd.health.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Transactional
@Service
public class MemberService {

    private MemberRepository memberRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Member signUp(String account, String password) {
        Optional<Member> members = memberRepository.findByAccount(account);
        Member member = members.get();
        log.info(member.toString());
        String encodedPassword = (member == null) ? "" : member.getPassword();
        if (member == null || !passwordEncoder.matches(password, encodedPassword)) {
            return null;
        }
        return member;
    }

    public Long create(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getSeq();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByAccount(member.getAccount()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

}
