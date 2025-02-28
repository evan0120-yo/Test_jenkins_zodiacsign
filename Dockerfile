FROM openjdk:17-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} zodiacsign.jar
ENTRYPOINT ["java","-jar","/zodiacsign.jar"]