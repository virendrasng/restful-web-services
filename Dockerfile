FROM java:8

FROM maven:3

EXPOSE 8080

ADD /src src

ADD /pom.xml pom.xml

RUN mvn package

ADD /target/restful-web-services.jar restful-web-services.jar

ENTRYPOINT [“java”, “-jar”, “restful-web-services.jar”]
