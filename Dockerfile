FROM java:8

FROM maven:3

EXPOSE 8080

mvn package

ADD /target/restful-web-services.jar restful-web-services.jar

ENTRYPOINT [“java”, “-jar”, “restful-web-services.jar”]
