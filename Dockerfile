# Étape 1
FROM maven:3.9.6-eclipse-temurin AS builder
WORKDIR /app
COPY pom.xml mvnw ./
COPY src src
RUN mvn clean package -DskipTests

# Étape 2
FROM openjdk:21-jdk-slim
COPY --from=builder /app/target/app1-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]