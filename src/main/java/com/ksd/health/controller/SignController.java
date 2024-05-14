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
    private HttpSession httpSession;

    @Autowired
    public SignController(MemberService memberService, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-in")
    private String signInPage() {
        return "sign/sign-in";
    }

    @PostMapping("/sign-in")
    private String signUp(HttpServletRequest req, MemberSignInForm memberSignInForm) {
        Member signIpMember = memberService.signIn(memberSignInForm.getAccount(), memberSignInForm.getPassword());
        if (signIpMember != null) {
            httpSession = req.getSession();
            httpSession.setAttribute("signInMember", signIpMember);
            httpSession.setMaxInactiveInterval(60 * 30);
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

    @GetMapping("/sign-up")
    private String signUp() {
        return "sign/sign-up";
    }

    @PostMapping("/create")
    private String create(MemberSignUpForm memberSignUpForm) {
        memberService.create(memberSignUpForm);
        return "index";
    }
}
