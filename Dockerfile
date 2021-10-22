FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY target/projeto-conta-bancaria-0.0.1-SNAPSHOT.jar /app/conta-bancaria-app.jar
           

ENTRYPOINT ["java","-jar","conta-bancaria-app.jar"]