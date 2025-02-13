FROM openjdk:21

WORKDIR /app

COPY ./target/guests-0.0.1-SNAPSHOT.jar .

ENTRYPOINT java -jar guests-0.0.1-SNAPSHOT.jar