FROM java:8-alpine
MAINTAINER "es-curl server"
ADD spring-cloud-eureka-server-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
