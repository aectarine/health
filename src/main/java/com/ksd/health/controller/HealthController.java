package com.ksd.health.controller;

import com.ksd.health.model.HealthBoard;
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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

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
            healthBoardService.create(healthBoardForm);
        }
        return "redirect:/";
    }

    @GetMapping("/health/list")
    @ResponseBody
    private List<HealthBoard> healthBoardList(HttpServletRequest req) {
        httpSession = req.getSession();
        List<HealthBoard> list = null;
        if (httpSession != null) {
            Member member = (Member) httpSession.getAttribute("signInMember");
            list = healthBoardService.list();
        }
        return list;
    }
}
