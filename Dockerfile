# Etapa 1: construir Angular
FROM node:18 AS frontend
WORKDIR /app
COPY frontend/ ./
RUN npm install && npm run build --prod

# Etapa 2: construir Spring Boot
FROM maven:3.9-eclipse-temurin-17 AS backend
WORKDIR /app
COPY backend/pom.xml ./
COPY backend/src ./src
# Copiamos el frontend generado al backend como recursos estáticos
COPY --from=frontend /app/dist /app/src/main/resources/static
RUN mvn clean package -DskipTests

# Etapa 3: imagen final para ejecución
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=backend /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
