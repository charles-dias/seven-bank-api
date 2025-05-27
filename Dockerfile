# Stage 1: build
FROM eclipse-temurin:21-jdk AS builder
WORKDIR /app

# copia pom, wrapper e baixar dependências offline
COPY mvnw pom.xml ./
COPY .mvn .mvn
RUN chmod +x mvnw && ./mvnw dependency:go-offline

# copia o código e empacota
COPY src src
RUN ./mvnw package -DskipTests

# Stage 2: runtime
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
