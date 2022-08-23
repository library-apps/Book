FROM openjdk:17-jdk-alpine
EXPOSE 8098
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "jar", "/app.jar"]