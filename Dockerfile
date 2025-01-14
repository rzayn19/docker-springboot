# For Java 8, try this
# FROM openjdk:8-jdk-alpine

# For Java 17, try this
FROM openjdk:17-alpine

# Refer to Maven build -> finalName
ARG JAR_FILE=target/spring-boot-web.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/
COPY ${JAR_FILE} .

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","spring-boot-web.jar"]
