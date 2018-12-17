FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY ./target/xeus-vgdb-backend-1.0-SNAPSHOT.jar /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","xeus-vgdb-backend-1.0-SNAPSHOT.jar"]
