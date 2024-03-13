FROM openjdk:18-alpine

WORKDIR /app

COPY target/cronjob-shedlock.jar cronjob-shedlock.jar

ENTRYPOINT ["java", "-jar", "cronjob-shedlock.jar"]

EXPOSE 6969

