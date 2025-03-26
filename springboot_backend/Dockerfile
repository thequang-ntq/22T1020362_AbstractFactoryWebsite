FROM maven:3.9-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
COPY --from=build /target/springboot_backend-0.0.1-SNAPSHOT.jar springboot_backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","springboot_backend.jar"]