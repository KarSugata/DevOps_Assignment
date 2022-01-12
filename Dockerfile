FROM openjdk:8-jdk-alpine
COPY target/ThemeParkRide-0.0.1-SNAPSHOT.jar rides-server-1.0.0.jar
ENTRYPOINT ["java","-jar","/rides-server-1.0.0.jar"]