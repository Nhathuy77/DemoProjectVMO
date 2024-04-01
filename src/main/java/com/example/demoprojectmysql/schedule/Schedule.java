package com.example.demoprojectmysql.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class Schedule {

    @Scheduled(cron = "0 0/1 * * * *")
    public void checkOrder(){
        System.out.println("Job start at: " + Instant.now());

    }
}
