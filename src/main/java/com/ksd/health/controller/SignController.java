package com.ksd.health.controller;

import com.ksd.health.model.Member;
import com.ksd.health.service.MemberService;
import com.ksd.health.vo.member.MemberSignInForm;
import com.ksd.health.vo.member.MemberSignUpForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@RequestMapping("/sign")
@Controller
public class SignController {

    private MemberService memberService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public SignController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    private String signUpPage() {
        return "sign/sign-up";
    }

    @PostMapping("/sign-up")
    private String signUp(HttpServletRequest req, MemberSignUpForm memberSignUpForm) {
        Member signUpMember = memberService.signUp(memberSignUpForm.getAccount(), memberSignUpForm.getPassword());
        if (signUpMember != null) {
            HttpSession session = req.getSession();
            session.setAttribute("signUpMember", signUpMember);
            session.setMaxInactiveInterval(60 * 30);
        }
        return "redirect:/";
    }

    @GetMapping("/sign-out")
    public String signOut(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/sign-in")
    private String signIn() {
        return "sign/sign-in";
    }

    @PostMapping("/create")
    private String create(MemberSignInForm memberSignInForm) {
        Member member = new Member();
        member.setAccount(memberSignInForm.getAccount());
        member.setPassword(passwordEncoder.encode(memberSignInForm.getPassword()));
        member.setName(memberSignInForm.getName());
        member.setEmail(memberSignInForm.getEmail());
        member.setPhone(memberSignInForm.getPhone());
        memberService.create(member);
        return "redirect:/";
    }
}
