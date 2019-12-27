FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

MAINTAINER Rasool

COPY pom.xml /hospital-application/

COPY src /hospital-application/src/

WORKDIR /hospital-application/

RUN mvn package

FROM openjdk:8-jre-alpine

WORKDIR /app

COPY --from=MAVEN_BUILD /hospital-application/target/hospital-application-0.0.1-SNAPSHOT.jar /app/

ENTRYPOINT ["java", "-jar", "hospital-application-0.0.1-SNAPSHOT.jar"]m","-jar","/app.jar"]