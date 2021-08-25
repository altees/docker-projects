FROM openjdk:8
ADD target/payment-service-0.0.1-SNAPSHOT.jar payment-service.jar
EXPOSE 8182
ENTRYPOINT ["java","-jar","payment-service.jar"]
