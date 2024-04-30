package com.ksd.health.controller;

import com.ksd.health.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
public class IndexController {

    @GetMapping("/")
    private String index(@SessionAttribute(name = "signUpMember", required = false) Member signUpMember, Model model) {
        if (signUpMember != null) {
            model.addAttribute("account", signUpMember.getName());
        }
        return "index";
    }
}
