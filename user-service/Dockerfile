FROM openjdk:8
ADD target/user-service-0.0.1-SNAPSHOT.jar user-service.jar
EXPOSE 8181
ENTRYPOINT ["java","-jar","user-service.jar"]
