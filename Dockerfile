FROM java:8

FROM maven:3

EXPOSE 8080

ADD /src src

ADD /pom.xml pom.xml

RUN mvn clean install -Dmaven.test.skip=true

ADD /root/.m2/repository/com/example/restful-web-services/0.0.1-SNAPSHOT/restful-web-services-0.0.1-SNAPSHOT.jar restful-web-services-0.0.1-SNAPSHOT.jar

ENTRYPOINT [“java”, “-jar”, “restful-web-services-0.0.1-SNAPSHOT.jar”]
