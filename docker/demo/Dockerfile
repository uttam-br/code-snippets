# Stage 1 : Build
FROM eclipse-temurin:21-jdk-alpine AS build

WORKDIR /app

COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN chmod +x mvnw

RUN --mount=type=cache,target=/root/.m2 ./mvnw dependency:go-offline

COPY src src
RUN --mount=type=cache,target=/root/.m2 /mvnw package -DskipTests


# Stage 2 : Runtime
FROM eclipse-termurin:21-jre-alpine
WORKDIR /app

# create non-root user for security
RUN addgroud -S spring && adduser -S spring -G spring

USER spring:spring

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT["java", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]