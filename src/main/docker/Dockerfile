FROM openjdk:11-jdk-slim
VOLUME /tmp
ADD pns-service-0.0.1-SNAPSHOT.jar app.jar
COPY galeno-pns-firebase-adminsdk-tz8m0-dbdc1f489e.json .
COPY application.properties .
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
