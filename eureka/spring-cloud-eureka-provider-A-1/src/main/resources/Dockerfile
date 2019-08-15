FROM java:8-alpine
MAINTAINER "es-curl server"
ADD spring-cloud-eureka-provider-A-1-1.0-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/app.jar"]
