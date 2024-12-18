#build stage
FROM maven:3.8.7-openjdk-18 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

#runtime stage
FROM amazoncorretto:17

#define arguments
ARG APP_VERSION=1.0.0

WORKDIR /app
COPY --from=build /build/target/*.jar app.jar

#expose port
EXPOSE 8080

#define environment variables
ENV DB_URL=jdbc:postgresql://postgres-smart-accounting:5432/smart-accounting-db
ENV JAR_VERSION=${APP_VERSION}

#defining the command

CMD ["java", "-jar", "-Dspring.datasource.url=${DB_URL}", "app.jar"]

