FROM amazoncorretto:21
EXPOSE 8080
ARG JAR_FILE=target/webpos-0.5.0.jar
ADD $JAR_FILE app.jar
ENTRYPOINT ["java","-jar","app.jar"]