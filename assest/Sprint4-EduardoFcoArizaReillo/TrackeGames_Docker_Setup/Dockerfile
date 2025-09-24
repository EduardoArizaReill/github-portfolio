# Etapa de construcción con Java 21
FROM maven:3.9.4-eclipse-temurin-21 AS build

WORKDIR /app

COPY TrackeGames/ ./TrackeGames/

WORKDIR /app/TrackeGames

RUN mvn clean package -DskipTests

# Etapa final también con Java 21
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/TrackeGames/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
