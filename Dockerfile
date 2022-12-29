FROM maven:3.8.6-eclipse-temurin-17 AS BUILDER

WORKDIR build

COPY alticci-api alticci-api
COPY alticci-ui alticci-ui
COPY pom.xml pom.xml
RUN mvn clean package

FROM bellsoft/liberica-openjdk-alpine:17.0.3

WORKDIR /usr/share/app

COPY --from=BUILDER /build/alticci-api/target/quarkus-app/ .

CMD ["java", "-jar", "quarkus-run.jar"]