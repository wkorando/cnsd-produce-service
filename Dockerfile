FROM adoptopenjdk/openjdk8-openj9:alpine-slim

COPY target/produce-service.jar /

ENTRYPOINT ["java", "-jar", "produce-service.jar" ]
