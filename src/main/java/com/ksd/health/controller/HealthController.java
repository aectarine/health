package com.ksd.health.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/health")
@Controller
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "health/health";
    }
}
