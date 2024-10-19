# Start with a Maven image for building the app
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Start with a lightweight Java runtime image for running the app
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/library-0.0.1-SNAPSHOT.jar myapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "myapp.jar"]
