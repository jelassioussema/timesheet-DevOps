FROM openjdk:15-jdk-alpine
EXPOSE 8080
ARG JAR_FILE=target/timesheet-ci.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]