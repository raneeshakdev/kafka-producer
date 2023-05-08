FROM openjdk:11
WORKDIR /app
COPY target/kafka-producer-0.0.1-SNAPSHOT.jar /app
EXPOSE 8300
CMD ["java" , "-jar" , "kafka-producer-0.0.1-SNAPSHOT.jar"]