FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
COPY . .
RUN mvn package -DskipTests

FROM eclipse-temurin:17-alpine
COPY --from=build target/supermarketpetizedocker.jar app.jar
EXPOSE 8082
CMD [ "java","-jar","app.jar"]