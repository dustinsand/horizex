# Use a lightweight JDK base image
FROM openjdk:24-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file
COPY target/horizex-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
