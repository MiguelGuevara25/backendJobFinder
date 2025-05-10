FROM amazoncorretto:23-al2023-jdk

COPY target/jobFinder-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java" , "-jar" , "/app.jar"]