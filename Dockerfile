FROM maven:3.8.4-jdk-11
WORKDIR /app
COPY pom.xml /app/
RUN ./mvnw dependency:resolve
# erro acima não sei pq
EXPOSE 9320
ENTRYPOINT [ "java", "-jar", "/app.jar" ]