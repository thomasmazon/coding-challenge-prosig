FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*[^source].jar

COPY ${JAR_FILE} application.jar
CMD apt-get update -y
ENTRYPOINT ["java", "-Xmx2048M", "-jar", "/application.jar"]
