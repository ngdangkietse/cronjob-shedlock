migrate-cronjob-shedlock:
	mvn flyway:migrate -Dflyway.configFiles=src/main/resources/db/config/flyway_shedlock_cron_db.conf