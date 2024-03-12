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
        log.info("Cron job is running");
        Instant start = Instant.now();
        Thread.sleep(10000);
        Instant end = Instant.now();
        log.info("Cron job is finished in {} ms", Duration.between(start, end).toSeconds());
    }
}
