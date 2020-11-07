FROM maven:3.6-jdk-11 AS build
LABEL name=rallee-be
LABEL version=0.0.1

COPY src /usr/src/app/src  
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -q

FROM openjdk:11
# copy any jar files into the image
COPY --from=build /usr/src/app/target/*.jar /usr/app/rallee-be.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/usr/app/rallee-be.jar"]