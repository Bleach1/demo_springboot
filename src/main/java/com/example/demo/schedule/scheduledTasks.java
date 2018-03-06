package com.example.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class scheduledTasks {

    @Scheduled(fixedDelay = 1000)
    public void scheduleTest() {
//执行任务  不推荐使用
       // System.out.print("每隔一秒来一发");
    }

}
