FROM adoptopenjdk/openjdk11:alpine

WORKDIR /usr/app

COPY build/libs/gamist-0.0.1-SNAPSHOT.jar .

EXPOSE 8080