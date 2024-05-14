package com.ksd.health.service;

import com.ksd.health.model.Member;
import com.ksd.health.repository.MemberRepository;
import com.ksd.health.vo.member.MemberSignUpForm;
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

    public Member signIn(String account, String password) {
        Optional<Member> members = memberRepository.findByAccount(account);
        Member member = members.get();
        String encodedPassword = (member == null) ? "" : member.getPassword();
        if (member == null || !passwordEncoder.matches(password, encodedPassword)) {
            return null;
        }
        return member;
    }

    public Long create(MemberSignUpForm memberSignInForm) {
        Member member = settingMember(memberSignInForm);
        checkAccountDup(member);
        checkPwdDup(member);
        memberRepository.save(member);
        return member.getSeq();
    }

    private void checkAccountDup(Member member) {
        memberRepository.findByAccount(member.getAccount()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    private void checkPwdDup(Member member) {

    }

    private Member settingMember(MemberSignUpForm memberSignInForm) {
        Member member = new Member();
        member.setAccount(memberSignInForm.getAccount());
        member.setPassword(passwordEncoder.encode(memberSignInForm.getPassword()));
        member.setName(memberSignInForm.getName());
        member.setEmail(memberSignInForm.getEmail());
        member.setPhone(memberSignInForm.getPhone());
        return member;
    }

}
