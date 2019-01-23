FROM openjdk:jdk-alpine

RUN mkdir /app
COPY ./build/libs/hello-spring-boot-0.0.1.jar /app/hello-spring-boot-0.0.1.jar
WORKDIR /app

EXPOSE 8080

CMD /bin/sh -c "java -jar hello-spring-boot-0.0.1.jar"
