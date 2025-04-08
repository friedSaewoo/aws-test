FROM openjdk:17
WORKDIR /app
COPY build/libs/aws_test-0.0.1-SNAPSHOT.jar aws_test-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "aws_test-0.0.1-SNAPSHOT.jar"]