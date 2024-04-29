# Utiliza una imagen base oficial de Maven para compilar el proyecto
FROM maven:3.8.4-openjdk-17-slim as build

# Copia solo el archivo pom.xml inicialmente
COPY pom.xml /home/app/pom.xml

# Configura el directorio de trabajo donde se ejecutarán los comandos de Maven
WORKDIR /home/app

# Descarga todas las dependencias necesarias
RUN mvn dependency:go-offline

# Ahora, copia el resto del código fuente
COPY src /home/app/src

# Compila el proyecto y empaqueta el ejecutable
RUN mvn clean package

# Utiliza una imagen base de Java para ejecutar la aplicación
FROM openjdk:17-slim

# Copia el ejecutable desde el contenedor de compilación al contenedor de ejecución
COPY --from=build /home/app/target/orquestator-0.0.1-SNAPSHOT.jar /usr/local/lib/orquestator.jar

# Expone el puerto en el que la aplicación estará disponible
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/usr/local/lib/orquestator.jar"]