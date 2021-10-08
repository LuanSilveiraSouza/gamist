FROM openjdk:11-jre-slim

EXPOSE 8080

RUN mkdir /app

COPY src/infra/build/libs/infra-0.0.1.jar /app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
