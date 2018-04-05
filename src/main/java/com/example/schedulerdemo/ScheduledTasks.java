package com.example.schedulerdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * Created by Arif Heer on 04/04/2018
 */

/**
 * Here i am working with scheduling and Thread concept is implement over here
 */



@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    @Scheduled(fixedRate = 60000)
    public void scheduleTaskWithFixedRate() {
        logger.info("The Fixed Rate Task Starting now : Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
    }

    @Scheduled(fixedDelay = 60000)
    public void scheduleTaskWithFixedDelay() {
        logger.info("Fixed Delay Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException ex) {
            logger.error("Ran into an error {}", ex);
            throw new IllegalStateException(ex);
        }
    }

    @Scheduled(fixedRate = 60000)
    public void scheduleTaskWithInitialDelay() {
        logger.info("Fixed Rate Task with Initial Delay : Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }

    @Scheduled(cron = "*/60 * * * * *")
    public void scheduleTaskWithCronExpression() {
        logger.info("Cron Task of One minute : Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }


//    @Scheduled(cron="*/180 * * * * *")
//    public void scheduleTaskWithCronExpreesionWith5Minutes(){
//        logger.info("cron Task of 3 minutes : Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
//
//
//    }

}
