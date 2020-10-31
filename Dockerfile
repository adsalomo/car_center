FROM openjdk:11
VOLUME /tmp
ADD ./target/car-center-api-1.0-SNAPSHOT.jar car-center-service.jar
ENTRYPOINT ["java", "-jar", "/car-center-service.jar"]
