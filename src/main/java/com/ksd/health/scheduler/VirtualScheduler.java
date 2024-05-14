package com.ksd.health.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Profile("dev")
@Slf4j
@Service
public class VirtualScheduler {
    @Primary
    @Scheduled(fixedRate = 30_000)
    public void fixedRate() {
        Date date = new Date();
        log.info("Now: {} thread: {}", date, Thread.currentThread());
    }
}
