FROM java:8-alpine
MAINTAINER "eureka server"
ADD spring-cloud-eureka-consumer-A-1-1.0-SNAPSHOT.jar app.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "/app.jar"]
