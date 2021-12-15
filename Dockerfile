FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim
COPY ./target/weatherDB*.jar weatherDB.jar
EXPOSE 8080
CMD java -jar weatherDB.jar