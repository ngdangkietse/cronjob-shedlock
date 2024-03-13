package dev.ngdangkietse.cronjobshedlock.jobs;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

/**
 * @author ngdangkietse
 * @since 3/12/2024
 */

@Component
@Slf4j
public class ShedLockJobSchedule {

    @Scheduled(cron = "${shedlock.job.cron}")
    @SchedulerLock(
            name = "${shedlock.job.name}",
            lockAtLeastFor = "${shedlock.job.lockAtLeastFor}",
            lockAtMostFor = "${shedlock.job.lockAtMostFor}")
    public void execute() throws InterruptedException {
        Instant start = Instant.now();
        log.info("===================================================");
        log.info("Start: {}", start);
        Thread.sleep(10000);
        Instant end = Instant.now();
        log.info("End: {}", end);
        log.info("Duration: {}", Duration.between(start, end));
        log.info("===================================================");
    }
}
