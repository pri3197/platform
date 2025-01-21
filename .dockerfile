# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file to the container
COPY target/my-spring-app.jar platform-0.0.1-SNAPSHOT.jar

# Expose port 8080
EXPOSE 9090

# Run the application
ENTRYPOINT ["java", "-jar", "platform-0.0.1-SNAPSHOT.jar"]
