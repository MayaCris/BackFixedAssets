# Usa una imagen base con OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /home/app

# Copia el archivo JAR de tu aplicación en el contenedor
COPY build/libs/fixedAssets-1.0.jar /home/app/fixedAssets-1.0.jar

# Expone el puerto en el que tu aplicación Spring Boot escucha (por defecto 8080)
EXPOSE 8070

# Define el comando para ejecutar tu aplicación
CMD ["java", "-jar", "-Dspring.profiles.active=pdn" ,"/home/app/fixedAssets-1.0.jar"]