# Use Maven to build the app
FROM maven:3.8.1-openjdk-17-slim as build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the project files
COPY . .

# Build the JAR file
RUN mvn clean package -DskipTests

# Use OpenJDK as the base image for the final build
FROM openjdk:17-alpine

# Set the working directory
WORKDIR /opt/app

# Copy the JAR file from the build stage
COPY --from=build /app/target/spring-boot-web.jar .

# Run the application
ENTRYPOINT ["java", "-jar", "spring-boot-web.jar"]