migrate-local:
	mvn flyway:migrate -Dflyway.configFiles=src/main/resources/db/config/local/flyway_shedlock_cron_db.conf
migrate-prod:
	mvn flyway:migrate -Dflyway.configFiles=src/main/resources/db/config/prod/flyway_shedlock_cron_db.conf
gen-java:
	mvn clean install -Dmaven.test.skip=true
dev-up-d:
	docker-compose -f docker-compose.dev.yml up -d
prod-up-d:
	docker-compose -f docker-compose.prod.yml up -d
dev-down:
	docker-compose -f docker-compose.dev.yml down
prod-down:
	docker-compose -f docker-compose.prod.yml down