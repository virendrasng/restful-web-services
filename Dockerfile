FROM java:8

EXPOSE 8080

ADD /target/restful-web-services.jar restful-web-services.jar

ENTRYPOINT [“java”, “-jar”, “restful-web-services.jar”]
