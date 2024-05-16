package com.ksd.health.controller;

import com.ksd.health.model.Member;
import com.ksd.health.service.HealthBoardService;
import com.ksd.health.vo.member.HealthBoardForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Enumeration;
import java.util.Iterator;

@RequestMapping("/health")
@Controller
public class HealthController {

    private HttpSession httpSession;
    private HealthBoardService healthBoardService;

    @Autowired
    public HealthController(HealthBoardService healthBoardService) {
        this.healthBoardService = healthBoardService;
    }

    @GetMapping("/health")
    public String health() {
        return "health/health";
    }

    @PostMapping("/health")
    public String create(HttpServletRequest req, HealthBoardForm healthBoardForm) {
        httpSession = req.getSession();
        if (httpSession != null) {
            Member member = (Member) httpSession.getAttribute("signInMember");
            healthBoardForm.setMember(member);
            System.out.println(healthBoardForm);
            healthBoardService.create(healthBoardForm);
        }
        return "redirect:/";
    }
}
