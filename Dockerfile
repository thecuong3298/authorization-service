FROM openjdk:11-jdk
COPY ./target/authorization-service-0.0.1.jar authorization-service.jar
ENTRYPOINT ["java","-jar","-Djava.security.egd=file:./config/application.yml","authorization-service.jar"]
