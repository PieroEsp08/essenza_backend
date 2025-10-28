# =========================
# Stage 1: Build
# =========================
# Imagen con Maven y Java 17 para compilar
FROM maven:3.9.0-eclipse-temurin-17 AS build

# Copiar todo el proyecto al contenedor
COPY . /app
WORKDIR /app

# Construir el proyecto sin ejecutar tests
RUN mvn clean package -DskipTests

# =========================
# Stage 2: Run
# =========================
# Imagen ligera solo con Java 17 para ejecutar el JAR
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiar el JAR generado en el build stage
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto (Render usa PORT dinámico)
EXPOSE 8080

# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
