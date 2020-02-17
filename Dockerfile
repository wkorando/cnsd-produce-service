FROM adoptopenjdk/openjdk8-openj9:alpine-slim

COPY target/produce-service.jar /

RUN /bin/sh -c 'java -Xshareclasses:cacheDir=/cache -Xscmx200M -jar produce-service.jar &' ; sleep 15

ENTRYPOINT ["java", "-Xshareclasses:cacheDir=/cache,readOnly", "-Xmx128M", "-jar", "produce-service.jar" ]
