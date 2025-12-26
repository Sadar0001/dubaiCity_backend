# 1. Build Stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy ALL project files (pom.xml, src folder, etc.)
COPY . .

# Now this will work because pom.xml is present
RUN mvn clean package -DskipTests

# 2. Run Stage
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]