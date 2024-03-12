package dev.ngdangkietse.cronjobshedlock.configurations;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;

/**
 * @author ngdangkietse
 * @since 3/12/2024
 */

@Configuration
@EnableScheduling
@EnableSchedulerLock(defaultLockAtLeastFor = "PT35S", defaultLockAtMostFor = "PT15M")
public class ShedLockConfiguration {

    @Bean
    public LockProvider lockProvider(DataSource dataSource) {
        return new JdbcTemplateLockProvider(dataSource);
    }
}
