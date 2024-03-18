migrate-local:
	mvn flyway:migrate -Dflyway.configFiles=src/main/resources/db/config/local/flyway_shedlock_cron_db.conf
migrate-prod:
	mvn flyway:migrate -Dflyway.configFiles=src/main/resources/db/config/prod/flyway_shedlock_cron_db.conf
gen-java:
	mvn clean install -Dmaven.test.skip=true
mysql-up:
	cd infras && docker-compose -f mysql.yml up -d
mysql-down:
	cd infras && docker-compose -f mysql.yml down
rancher-up:
	cd infras && docker-compose -f rancher.yml up -d
rancher-down:
	cd infras && docker-compose -f rancher.yml down
local-up:
	docker-compose -f docker-compose.local.yml up -d
prod-up:
	docker-compose -f docker-compose.prod.yml up -d
local-down:
	docker-compose -f docker-compose.local.yml down
prod-down:
	docker-compose -f docker-compose.prod.yml down
monitoring-up:
	cd infras/monitoring && docker-compose up -d
monitoring-down:
	cd infras/monitoring && docker-compose down