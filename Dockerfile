FROM eclipse-temurin:17-jre-alpine
ARG JAR_FILE=./build/libs/*OT.jar
COPY ${JAR_FILE} quote.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/quote.jar"]
