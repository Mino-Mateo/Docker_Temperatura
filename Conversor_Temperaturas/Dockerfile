# Define la imagen base de Java
FROM openjdk:latest
# Copia los archivos compilados al contenedor
COPY /src/* .
# Compila los archivos Java
RUN javac *.java
# Expone el puerto utilizado por RMI
EXPOSE 5000
# Inicia el servidor RMI al ejecutar el cosntenedor
CMD ["java", "ServidorRMI"]
